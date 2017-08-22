package com.unicom.mybatis.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Dian on 2017/7/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
@ComponentScan("com.unicom.mybatis")
public class IndexCataServiceTest {
    private static Logger logger = Logger.getLogger(IndexCataServiceTest.class);
   // private ApplicationContext ac = null;
    @Autowired
    private IndexCataService indexCataService;

    @Test
    public void selectIndexCata(){
        String result = this.indexCataService.selectIndexCata();
        logger.info("信息："+result);
    }
    @Test
    public void selectFactoryCata(){
        String result = this.indexCataService.selectFactoryCata("original_4G","MR");
        logger.info("二级页面信息："+result);
    }


}