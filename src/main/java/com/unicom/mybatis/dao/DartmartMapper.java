package com.unicom.mybatis.dao;

import com.unicom.mybatis.pojo.Dartmart;

import java.util.List;
import java.util.Map;

public interface DartmartMapper {
    int insert(Dartmart record);

    int insertSelective(Dartmart record);

    List<Map<String,Object>> selectDataCata(Map paramMap);

    List<Map<String,Object>> selectDataDate(Map paramMap);
}