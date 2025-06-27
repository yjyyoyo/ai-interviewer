package com.itzixi.service;

import com.itzixi.pojo.Job;
import com.itzixi.pojo.bo.JobBO;
import com.itzixi.utils.PagedGridResult;

import java.util.HashMap;
import java.util.List;

public interface JobService {

    /**
     * @Description: 创建或者更新职位信息
     * @Author 风间影月
     * @param jobBO
     */
    public void createOrUpdate(JobBO jobBO);

    /**
     * @Description: 分页查询职位列表
     * @Author 风间影月
     * @param page
     * @param pageSize
     * @return PagedGridResult
     */
    public PagedGridResult queryList(Integer page, Integer pageSize);

    /**
     * @Description: 查询职位详情
     * @Author 风间影月
     * @param id
     * @return Job
     */
    public Job getDetail(String id);

    /**
     * @Description: 删除职位详情
     * @Author 风间影月
     * @param id
     */
    public void delete(String id);

    /**
     * @Description: 判断所有职位中是否包含某个面试官
     * @Author 风间影月
     * @param InterviewerId
     * @return boolean
     */
    public boolean isJobContainInterviewer(String InterviewerId);

    /**
     * @Description: 获得所有岗位名称的列表
     * @Author 风间影月
     * @param
     * @return List<HashMap<String,String>>
     */
    public List<HashMap<String, String>> nameList();
}
