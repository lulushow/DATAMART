package com.unicom.mybatis.util;

import com.unicom.mybatis.service.IndexCataServiceTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Dian on 2017/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
@ComponentScan("com.unicom.mybatis")
public class numFormatTest {
    private NumFormat numFormat;
    private static Logger logger = Logger.getLogger(numFormatTest.class);
    @Test
    public void numFormat() throws Exception {
        numFormat = new NumFormat();
        long num = 8408212795L;
        logger.info(this.numFormat.numFormat(num));


    }

}