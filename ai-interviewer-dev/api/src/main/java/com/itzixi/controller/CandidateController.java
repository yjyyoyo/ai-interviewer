package com.itzixi.controller;

import com.itzixi.grace.result.GraceJSONResult;
import com.itzixi.pojo.bo.CandidateBO;
import com.itzixi.pojo.bo.JobBO;
import com.itzixi.service.CandidateService;
import com.itzixi.utils.PagedGridResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CandidateController
 * @Author 公众号【风间影月】
 * @Version 1.0
 * @Description CandidateController
 **/
@RestController
@RequestMapping("candidate")
public class CandidateController {

    @Resource
    private CandidateService candidateService;

    /**
     * @Description: 创建或者更新候选人的信息
     * @Author 风间影月
     * @param candidateBO
     * @return GraceJSONResult
     */
    @PostMapping("createOrUpdate")
    public GraceJSONResult createOrUpdate(@RequestBody CandidateBO candidateBO) {
        candidateService.createOrUpdate(candidateBO);
        return GraceJSONResult.ok();
    }

    /**
     * @Description: 条件搜索候选人的列表
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
        PagedGridResult result = candidateService.queryList(realName, mobile, page, pageSize);
        return GraceJSONResult.ok(result);
    }

    /**
     * @Description: 查询候选人
     * @Author 风间影月
     * @param candidateId
     * @return GraceJSONResult
     */
    @GetMapping("detail")
    public GraceJSONResult detail(@RequestParam String candidateId) {
        return GraceJSONResult.ok(candidateService.getDetail(candidateId));
    }

    /**
     * @Description: 删除候选人
     * @Author 风间影月
     * @param candidateId
     * @return GraceJSONResult
     */
    @PostMapping("delete")
    public GraceJSONResult delete(@RequestParam String candidateId) {
        candidateService.delete(candidateId);
        return GraceJSONResult.ok();
    }
}
