package com.itzixi.controller;

import com.itzixi.grace.result.GraceJSONResult;
import com.itzixi.pojo.bo.JobBO;
import com.itzixi.service.JobService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName JobController
 * @Author 公众号【风间影月】
 * @Version 1.0
 * @Description JobController
 **/
@RestController
@RequestMapping("job")
public class JobController {

    @Resource
    private JobService jobService;

    /**
     * @Description: 创建或者更新职位信息
     * @Author 风间影月
     * @param jobBO
     * @return GraceJSONResult
     */
    @PostMapping("createOrUpdate")
    public GraceJSONResult createOrUpdate(@RequestBody JobBO jobBO) {
        jobService.createOrUpdate(jobBO);
        return GraceJSONResult.ok();
    }

    /**
     * @Description: 分页查询职位信息列表
     * @Author 风间影月
     * @param page
     * @param pageSize
     * @return GraceJSONResult
     */
    @GetMapping("list")
    public GraceJSONResult list(@RequestParam(defaultValue = "1", name = "page") Integer page,
                                @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize) {
        return GraceJSONResult.ok(jobService.queryList(page, pageSize));
    }

    /**
     * @Description: 查询职位详情
     * @Author 风间影月
     * @param jobId
     * @return GraceJSONResult
     */
    @GetMapping("detail")
    public GraceJSONResult detail(String jobId) {
        return GraceJSONResult.ok(jobService.getDetail(jobId));
    }

    /**
     * @Description: 删除职位详情
     * @Author 风间影月
     * @param jobId
     * @return GraceJSONResult
     */
    @PostMapping("delete")
    public GraceJSONResult delete(String jobId) {
        jobService.delete(jobId);
        return GraceJSONResult.ok();
    }

    /**
     * @Description: 查询并且获得所有包含名称的岗位列表
     * @Author 风间影月
     * @param
     * @return GraceJSONResult
     */
    @GetMapping("nameList")
    public GraceJSONResult nameList() {
        return GraceJSONResult.ok(jobService.nameList());
    }

}
