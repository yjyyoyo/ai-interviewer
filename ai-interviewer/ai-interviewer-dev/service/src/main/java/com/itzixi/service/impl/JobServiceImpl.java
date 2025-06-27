package com.itzixi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.itzixi.base.BaseInfoProperties;
import com.itzixi.mapper.JobMapper;
import com.itzixi.mapper.JobMapperCustom;
import com.itzixi.pojo.Job;
import com.itzixi.pojo.bo.JobBO;
import com.itzixi.pojo.vo.JobVO;
import com.itzixi.service.JobService;
import com.itzixi.utils.PagedGridResult;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName JobServiceImpl
 * @Author 公众号【风间影月】
 * @Version 1.0
 * @Description JobServiceImpl
 **/
@Service
public class JobServiceImpl extends BaseInfoProperties implements JobService {

    @Resource
    private JobMapper jobMapper;

    @Resource
    private JobMapperCustom jobMapperCustom;

    @Override
    public void createOrUpdate(JobBO jobBO) {
        Job job = new Job();
        BeanUtils.copyProperties(jobBO, job);
        job.setCreateTime(LocalDateTime.now());

        if (StringUtils.isBlank(job.getId())) {
            job.setUpdatedTime(LocalDateTime.now());
            jobMapper.insert(job);
        } else {
            jobMapper.updateById(job);
        }
    }

    @Override
    public PagedGridResult queryList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<JobVO> jobList = jobMapperCustom.queryJobList(null);
        return setterPagedGrid(jobList, page);
    }

    @Override
    public Job getDetail(String id) {
        return jobMapper.selectById(id);
    }

    @Override
    public void delete(String id) {
        jobMapper.deleteById(id);
    }

    @Override
    public boolean isJobContainInterviewer(String InterviewerId) {

        QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interviewer_id", InterviewerId);

        Long counts = jobMapper.selectCount(queryWrapper);

        return counts > 0 ? true : false;
    }

    @Override
    public List<HashMap<String, String>> nameList() {
        return jobMapperCustom.queryNameList(null);
    }
}
