package com.unicom.mybatis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dian on 2017/7/17.
 */
public class MyDateFormat {
    /**
     * 日期格式化
     * @param oldDate
     * @return
     */
    public static String dateFormat(String oldDate){
        String newDate = oldDate;
        java.text.DateFormat dataformat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        java.text.DateFormat newformat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            date = dataformat.parse(oldDate);//字符串转日期
            newDate = newformat.format(date).toString();
        }catch (ParseException e){
            newDate = oldDate;
        }

        return newDate;

    }

    /**
     * 从日期中获取日，小于10的为一位如1而不是01
     * @param oldDate
     * @return
     */
    public static Integer getDay(String oldDate){
        String day = oldDate.substring(oldDate.length()-2,oldDate.length());
        return Integer.valueOf(day);
    }

    /**
     * 格式化为当前年月最小日期
     * @param year
     * @param month
     * @return
     */
    public static String minDate(String year,String month){
        if(Integer.valueOf(month)<10){
            month = "0"+month;
        }
        return year+month+"00";
    }

    /**
     * 格式化为当前年月最大日期
     * @param year
     * @param month
     * @return
     */
    public static String maxDate(String year,String month){
        if(Integer.valueOf(month)<10 && month.length()<2){
            month = "0"+month;
        }
        return year+month+"31";
    }
}
