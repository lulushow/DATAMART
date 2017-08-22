package com.unicom.mybatis.util;

/**
 * Created by Dian on 2017/7/17.
 */
public enum Province {
    AH("AH","安徽"),BJ("BJ","北京"),CQ("CQ","重庆"),FJ("FJ","福建"),GD("GD","广东"),
    GS("GS","甘肃"),GX("GX","广西"),GZ("GZ","贵州"),HEB("HEB","河北"),HEN("HEN","河南"),
    HLJ("HLJ","黑龙江"),HN("HN","海南"),HUB("HUB","湖北"),HUN("HUN","湖南"),JL("JL","吉林"),
    JS("JS","江苏"),JX("JX","江西"),LN("LN","辽宁"),NM("NM","内蒙"),NX("NX","宁夏"),QH("QH","青海"),
    SC("SC","四川"),SD("SD","山东"),SH("SH","上海"),SX("SX","陕西"),SXI("SXI","山西"),TJ("TJ","天津"),
    XJ("XJ","新疆"),XZ("XZ","西藏"),YN("YN","云南"),ZJ("ZJ","浙江"),XG("XG","香港"),AM("AM","澳门"),TW("TW","台湾");

    private String enProvince;//英文

    private String chProvince;//中文

    private Province(String enProvince,String chProvince){//构造函数
        this.enProvince = enProvince;
        this.chProvince = chProvince;
    }
    public String getEnProvince() {
        return enProvince;
    }

    public void setEnProvince(String enProvince) {
        this.enProvince = enProvince;
    }

    public String getChProvince() {
        return chProvince;
    }

    public void setChProvince(String chProvince) {
        this.chProvince = chProvince;
    }

    /**
     * 英文转为中文
     * @param enPro
     * @return
     */
    public static String enToCh(String enPro){
        String  result = "";
        for(Province province : Province.values()){
            if(enPro.equals(province.getEnProvince())){
                result =  province.getChProvince();
                break;
            }
        }

        return result;

    }

    /**
     * 中文转为英文
     * @param chPro
     * @return
     */
    public static String chToEn(String chPro){
        String  result = "";
        for(Province province : Province.values()){
            if(chPro.equals(province.getChProvince())){
                result =  province.getEnProvince();
                break;
            }
        }

        return result;
    }


}
