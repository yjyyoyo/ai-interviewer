package com.itzixi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.itzixi.base.BaseInfoProperties;
import com.itzixi.mapper.InterviewRecordMapper;
import com.itzixi.mapper.InterviewRecordMapperCustom;
import com.itzixi.pojo.InterviewRecord;
import com.itzixi.pojo.vo.CandidateVO;
import com.itzixi.pojo.vo.InterviewRecordVO;
import com.itzixi.service.InterviewRecordService;
import com.itzixi.utils.PagedGridResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName InterviewRecordServiceImpl
 * @Author 公众号【风间影月】
 * @Version 1.0
 * @Description InterviewRecordServiceImpl
 **/
@Service
public class InterviewRecordServiceImpl extends BaseInfoProperties implements InterviewRecordService {

    @Resource
    private InterviewRecordMapper interviewRecordMapper;

    @Resource
    private InterviewRecordMapperCustom interviewRecordMapperCustom;

    @Override
    public void save(InterviewRecord interviewRecord) {
        interviewRecordMapper.insert(interviewRecord);
    }

    @Override
    public boolean isCandidateRecordExist(String candidateId) {

        List<InterviewRecord> list = interviewRecordMapper.selectList(
                new QueryWrapper<InterviewRecord>()
                        .eq("candidate_id",candidateId)
        );

        if (list.isEmpty() || list.size() == 0) return false;

        return true;
    }

    @Override
    public PagedGridResult queryList(String realName, String mobile, Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);

        Map<String, Object> map = new HashMap<>();
        map.put("realName", realName);
        map.put("mobile", mobile);

        List<InterviewRecordVO> list = interviewRecordMapperCustom.queryList(map);
        return setterPagedGrid(list, page);
    }
}
