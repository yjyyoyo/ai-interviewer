package com.itzixi.service;

import com.itzixi.pojo.InterviewRecord;
import com.itzixi.utils.PagedGridResult;

public interface InterviewRecordService {

    /**
     * @Description: 保存面试结果
     * @Author 风间影月
     * @param interviewRecord
     */
    public void save(InterviewRecord interviewRecord);

    /**
     * @Description: 判断候选人是否面试过
     * @Author 风间影月
     * @param candidateId
     * @return boolean
     */
    public boolean isCandidateRecordExist(String candidateId);

    /**
     * @Description: 分页条件查询面试结果列表
     * @Author 风间影月
     * @param realName
     * @param mobile
     * @param page
     * @param pageSize
     * @return PagedGridResult
     */
    public PagedGridResult queryList(String realName, String mobile, Integer page, Integer pageSize);
}
