package com.unicom.mybatis.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unicom.mybatis.dao.DartmartCataMapper;
import com.unicom.mybatis.dao.DartmartMapper;
import com.unicom.mybatis.pojo.DartmartCata;
import com.unicom.mybatis.util.MyDateFormat;
import com.unicom.mybatis.util.NumFormat;
import com.unicom.mybatis.util.Province;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Dian on 2017/7/7.
 */
@Service
public class IndexCataService {
    @Autowired
    private DartmartCataMapper dartmartCataMapper;

    @Autowired
    private DartmartMapper dartmartMapper;

    /**
     * 查询首页数据
     * @return
     */
    public String selectIndexCata(){
        List<Map<String,Object>> indexCataData;
        indexCataData = this.dartmartCataMapper.selectIndexCata();
        //NumFormat numFormat = new NumFormat();
        JSONArray result= new JSONArray();
        JSONArray original4g = new JSONArray();
        JSONArray original3g = new JSONArray();
        JSONArray original2g = new JSONArray();
        String dataTime = "";
        for(int i=0;i<indexCataData.size();i++){
            Map<String,Object> map = indexCataData.get(i);

            JSONObject object = new JSONObject();
            if(map.get("DATATYPE").equals("original_4G")){
                object.put("datatype",map.get("DATABROADTYPE"));
                BigDecimal bigDecimal = (BigDecimal) map.get("DATASIZE");
                long dataSize = bigDecimal.longValue();
                object.put("datasize",NumFormat.numFormat(dataSize));
                dataTime = MyDateFormat.dateFormat(String.valueOf(map.get("NEWSESTDATE")));
                object.put("datatime", dataTime);
                original4g.add(object);
            }else if(map.get("DATATYPE").equals("original_3G")){
                object.put("datatype",map.get("DATABROADTYPE"));
                BigDecimal bigDecimal = (BigDecimal) map.get("DATASIZE");//数据转换
                long dataSize = bigDecimal.longValue();
                object.put("datasize",NumFormat.numFormat(dataSize));
                dataTime = MyDateFormat.dateFormat(String.valueOf(map.get("NEWSESTDATE")));

                object.put("datatime", dataTime);
                original3g.add(object);
            }else if(map.get("DATATYPE").equals("original_2G")){
                object.put("datatype",map.get("DATABROADTYPE"));
                BigDecimal bigDecimal = (BigDecimal) map.get("DATASIZE");
                long dataSize = bigDecimal.longValue();
                object.put("datasize",NumFormat.numFormat(dataSize));
                dataTime = MyDateFormat.dateFormat(String.valueOf(map.get("NEWSESTDATE")));
                object.put("datatime", dataTime);
                original2g.add(object);
            }
        }
        JSONObject object4g = new JSONObject();
        JSONObject object3g = new JSONObject();
        JSONObject object2g = new JSONObject();
        object4g.put("name","4G原始数据");
        object4g.put("info",original4g);
        object3g.put("name","3G原始数据");
        object3g.put("info",original3g);
        object2g.put("name","2G原始数据");
        object2g.put("info",original2g);
        result.add(object4g);
        result.add(object3g);
        result.add(object2g);
        return JSON.toJSONString(result);
    }

    /**
     * 查询二级页面数据
     * @param dataType
     * @param dataBroadType
     * @return
     */
    public String selectFactoryCata(String dataType,String dataBroadType){
        Map paramMap = new HashMap();//json格式真操蛋
        paramMap.put("dataType",dataType);
        paramMap.put("dataBroadType",dataBroadType);
        List<Map<String,Object>> factoryCata = this.dartmartCataMapper.selectFactoryCata(paramMap);
        JSONArray infoDetail = new JSONArray();
        //JSONObject result = new JSONObject();
        String dataTime = "";
        for(int i=0;i<factoryCata.size();i++){
            Map<String,Object> map = factoryCata.get(i);
            JSONObject object = new JSONObject();

            String factory = String.valueOf(map.get("FACTORY"));
            String netElement = String.valueOf(map.get("NETELEMENT"));
            String pointerType = String.valueOf(map.get("POINTERTYPE"));
            String introduce = String.valueOf(map.get("INTRODUCE"));
            if(factory.equals("") || factory.equals(null)){
                factory=null;
            }
            object.put("category",factory+"&"+netElement+"&"+pointerType);
            dataTime = MyDateFormat.dateFormat(String.valueOf(map.get("NEWSESTDATE")));
            object.put("datatime", dataTime);
            object.put("introduce",introduce);
            BigDecimal bigDecimal = (BigDecimal) map.get("DATASIZE");
            long dataSize = bigDecimal.longValue();
            object.put("datasize",NumFormat.numFormat(dataSize));
            infoDetail.add(object);
        }
        return JSON.toJSONString(infoDetail);
    }

    /**
     * 三级页面，根据类型、大类、厂家、网元、指标查询省份
     * @param dataType
     * @param dataBroadType
     * @param factory
     * @param netElement
     * @param pointerType
     * @return
     */
    public String selectDataCata(String dataType,String dataBroadType,String factory,String netElement,String pointerType){
        Map paramMap = new HashMap();
        if(dataType.equals("") || dataType.equals(null)){dataType=null;}
        if(dataBroadType.equals("") || dataBroadType.equals(null)){dataBroadType=null;}
        if(factory.equals("") || factory.equals(null)){factory=null;}
        if(netElement.equals("") || netElement.equals(null)){netElement=null;}
        if(pointerType.equals("") || pointerType.equals(null)){pointerType=null;}
        paramMap.put("dataType",dataType);
        paramMap.put("dataBroadType",dataBroadType);
        paramMap.put("factory",factory);
        paramMap.put("netElement",netElement);
        paramMap.put("pointerType",pointerType);
        List<Map<String,Object>> dataCata = this.dartmartMapper.selectDataCata(paramMap);
        List<Map<String,Object>> dataSample = this.dartmartCataMapper.selectDataSample(paramMap);
        Map<String,Object> map = null;
        JSONObject result = new JSONObject();
        //JSONArray result = new JSONArray();
        String provinces = "";
        for(int i=0;i<dataCata.size();i++){
            //JSONObject object = new JSONObject();
            map = dataCata.get(i);
            String province = Province.enToCh(String.valueOf(map.get("PROVINCE")));//省份英文转为中文
            //object.put("province",province);
            //result.add(province);
            provinces +=province+",";
        }
        int len = provinces.length();
        if(len>1){
            len -= 1;
        }
        provinces =  provinces.substring(0,len);
        result.put("province",provinces);
        for(int i=0;i<dataSample.size();i++){
            map = dataSample.get(i);
            result.put("dataDetail",String.valueOf(map.get("DATADETAIL")));
            result.put("dataExample",String.valueOf(map.get("DATAEXAMPLE")));
            result.put("introduce",String.valueOf(map.get("INTRODUCE")));
            break;
        }
        //String rs = JSON.toJSONString(result);
        //return rs.substring(1,rs.length()-1);

        return JSON.toJSONString(result);
    }

    /**
     * 根据省份查询日期
     * @param dataType
     * @param dataBroadType
     * @param province
     * @param factory
     * @param netElement
     * @param pointerType
     * @return
     */
    public String selectDataDate(String dataType,String dataBroadType,String province,String factory,String netElement,String pointerType,String year,String month){
        Map paramMap = new HashMap();
        if(dataType.equals("") || dataType.equals(null)){dataType=null;}
        if(dataBroadType.equals("") || dataBroadType.equals(null)){dataBroadType=null;}
        if(factory.equals("") || factory.equals(null)){factory=null;}
        if(netElement.equals("") || netElement.equals(null)){netElement=null;}
        if(pointerType.equals("") || pointerType.equals(null)){pointerType=null;}
        province = Province.chToEn(province);
        paramMap.put("dataType",dataType);
        paramMap.put("dataBroadType",dataBroadType);
        paramMap.put("province",province);
        paramMap.put("factory",factory);
        paramMap.put("netElement",netElement);
        paramMap.put("pointerType",pointerType);
        paramMap.put("minDate",MyDateFormat.minDate(year,month));
        paramMap.put("maxDate",MyDateFormat.maxDate(year, month));
        List<Map<String,Object>> dataDate = this.dartmartMapper.selectDataDate(paramMap);
        Map<String,Object> map = null;
        JSONArray result = new JSONArray();
        for(int i=0;i<dataDate.size();i++){
            //JSONObject object = new JSONObject();
            map = dataDate.get(i);
            //String allDate = MyDateFormat.dateFormat(String.valueOf(map.get("DATADATE")) );
            int day = MyDateFormat.getDay(String.valueOf(map.get("DATADATE")));
            //object.put("date",allDate);
            result.add(day);
        }
        String rs = JSON.toJSONString(result);
        int len = rs.length();
        if(len>1){
            len -= 1;
        }
        return rs.substring(1,len);
    }

    public String selectDataSample(String dataType,String dataBroadType,String factory,String netElement,String pointerType){
        Map paramMap = new HashMap();
        if(dataType.equals("") || dataType.equals(null)){dataType=null;}
        if(dataBroadType.equals("") || dataBroadType.equals(null)){dataBroadType=null;}
        if(factory.equals("") || factory.equals(null)){factory=null;}
        if(netElement.equals("") || netElement.equals(null)){netElement=null;}
        if(pointerType.equals("") || pointerType.equals(null)){pointerType=null;}
        paramMap.put("dataType",dataType);
        paramMap.put("dataBroadType",dataBroadType);
        paramMap.put("factory",factory);
        paramMap.put("netElement",netElement);
        paramMap.put("pointerType",pointerType);
        List<Map<String,Object>> dataSample = this.dartmartCataMapper.selectDataSample(paramMap);
        Map<String,Object> map = null;
        JSONObject result = new JSONObject();
        for(int i=0;i<dataSample.size();i++){
            map = dataSample.get(i);
            result.put("dataDetail",String.valueOf(map.get("DATADETAIL")));
            result.put("dataExample",String.valueOf(map.get("DATAEXAMPLE")));
            break;
        }
        return JSON.toJSONString(result);
    }
}
