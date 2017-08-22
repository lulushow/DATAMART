package com.unicom.mybatis.dao;

import com.unicom.mybatis.pojo.DartmartCata;

import java.util.List;
import java.util.Map;

public interface DartmartCataMapper {
    int insert(DartmartCata record);

    int insertSelective(DartmartCata record);

    List<Map<String,Object>> selectIndexCata();

    List<Map<String,Object>> selectFactoryCata(Map paramMap);

    List<Map<String,Object>> selectDataSample(Map paramMap);
}