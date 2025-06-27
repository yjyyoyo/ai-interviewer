package com.itzixi.controller;

import com.itzixi.ChatGLMTask;
import com.itzixi.grace.result.GraceJSONResult;
import com.itzixi.pojo.bo.SubmitAnswerBO;
import com.itzixi.service.InterviewRecordService;
import com.itzixi.utils.PagedGridResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName InterviewRecordController
 * @Author 公众号【风间影月】
 * @Version 1.0
 * @Description InterviewRecordController
 **/
@RestController
@RequestMapping("interviewRecord")
public class InterviewRecordController {

    @Resource
    private ChatGLMTask chatGLMTask;

    @Resource
    private InterviewRecordService interviewRecordService;

    /**
     * @Description: 提交面试的回答内容进行AI分析
     * @Author 风间影月
     * @param submitAnswerBO
     * @return GraceJSONResult
     */
    @PostMapping("collect")
    public GraceJSONResult collect(@RequestBody SubmitAnswerBO submitAnswerBO) {

        chatGLMTask.display(submitAnswerBO);

        return GraceJSONResult.ok();
    }

    /**
     * @Description: 分页查询条件搜索面试记录列表
     * @Author 风间影月
     * @param realName
     * @param mobile
     * @param page
     * @param pageSize
     * @return GraceJSONResult
     */
    @GetMapping("list")
    public GraceJSONResult list(@RequestParam String realName,
                                @RequestParam String mobile,
                                @RequestParam(defaultValue = "1", name = "page") Integer page,
                                @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize) {
        PagedGridResult result = interviewRecordService.queryList(realName, mobile, page, pageSize);
        return GraceJSONResult.ok(result);
    }

}
