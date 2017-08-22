package com.unicom.mybatis.util;

import java.text.DecimalFormat;

/**
 * Created by Dian on 2017/7/12.
 */
public class NumFormat {
    public static double TB = 1073741824;
    public static double GB = 1048576;

    /**
     * 数字格式化
     * @param num
     * @return String
     */
    public static String numFormat(long num){
        String result = null;
        double tbResult = num/TB;
        DecimalFormat decimalFormat=new DecimalFormat(".00");
        if(tbResult>1024){//大于1024TB
            tbResult = tbResult/1024.00;
            return decimalFormat.format(tbResult)+"PB";
        }else if(tbResult>1){//小于1PB，改用TB为单位
            return decimalFormat.format(tbResult)+"TB";
        }else if(tbResult<1 && num/GB>1){
            double gbResult = num/GB;
            return decimalFormat.format(gbResult)+"GB";
        }else if(num/1024>1 && num/GB<1){//MB
            double mbResult = num/1024.00;
            return decimalFormat.format(mbResult)+"MB";
        }else{
            return decimalFormat.format(num)+"KB";
        }
    }
}
