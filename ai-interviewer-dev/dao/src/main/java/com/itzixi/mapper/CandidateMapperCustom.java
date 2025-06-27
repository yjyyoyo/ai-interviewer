package com.itzixi.mapper;

import com.itzixi.pojo.bo.CandidateBO;
import com.itzixi.pojo.vo.CandidateVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CandidateMapperCustom {

    public List<CandidateVO> queryCandidateList(@Param("paramMap") Map<String, Object> map);

}
