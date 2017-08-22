package com.unicom.mybatis.controller;

import com.unicom.mybatis.service.IndexCataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dian on 2017/7/11.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IndexCataService indexCataService;
    @RequestMapping(value="/toIndex",method= RequestMethod.GET)
    public String toIndex(){
        return "index";
    }
    /**
     * 请求首页面数据
     * @return 首页面数据
     */
    @ResponseBody
    @RequestMapping(value="/queryIndex",method= RequestMethod.POST)
    public String IndexCatalog(){
        return this.indexCataService.selectIndexCata();
    }

    /**
     * 定位到二级页面
     * @return
     */
    @RequestMapping(value = "/toDetail")
    public String toSecondPage(){
        return "detail";
    }

    /**
     * 请求二级页面
     * @param dataType
     * @param dataBroadType
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/queryBroadData",method= RequestMethod.POST)
    public String SecondCata(@RequestParam("dataType")String dataType,@RequestParam("dataBroadType")String dataBroadType,Model model){
        model.addAttribute("dataType",dataType);
        model.addAttribute("dataBroadType",dataBroadType);
        return this.indexCataService.selectFactoryCata(dataType,dataBroadType);
    }

    /**
     * 请求三级页面
     * @return
     */
    @RequestMapping(value="/toProduct")
    public String toThirdPage(){return "product";};

    /**
     * 三级页面，根据以下参数查询所有的省份，省份为中文
     * @param dataType
     * @param dataBroadType
     * @param factory
     * @param netElement
     * @param pointerType
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/queryProvince",method= RequestMethod.POST)
    public String requestProvince(@ModelAttribute("dataType")String dataType,@ModelAttribute("dataBroadType")String dataBroadType,@RequestParam("factory")String factory,@RequestParam("netElement")String netElement,@RequestParam("pointerType")String pointerType,Model model){
        model.addAttribute("factory",factory);
        model.addAttribute("netElement",netElement);
        model.addAttribute("pointerType",pointerType);
        return this.indexCataService.selectDataCata(dataType,dataBroadType,factory,netElement,pointerType);
    }

    /**
     * 三级页面
     * 根据相关信息及省份查询所有日期，返回所有的日期，日期格式为YYYY-mm-DD
     * @param dataType
     * @param dataBroadType
     * @param factory
     * @param netElement
     * @param pointerType
     * @param province
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/queryDateByPro",method= RequestMethod.POST)
    public String requestDateByProvince(@ModelAttribute("dataType")String dataType,@ModelAttribute("dataBroadType")String dataBroadType,@ModelAttribute("factory")String factory,@ModelAttribute("netElement")String netElement,@ModelAttribute("pointerType")String pointerType,@RequestParam("province")String province,@RequestParam("year")String year,@RequestParam("month")String month){
        return this.indexCataService.selectDataDate(dataType,dataBroadType,province,factory,netElement,pointerType,year,month);
    }
    @ResponseBody
    @RequestMapping(value="/DataSample",method= RequestMethod.POST)
    public String queryDataSample(@ModelAttribute("dataType")String dataType,@ModelAttribute("dataBroadType")String dataBroadType,@ModelAttribute("factory")String factory,@ModelAttribute("netElement")String netElement,@ModelAttribute("pointerType")String pointerType){
        return this.indexCataService.selectDataSample(dataType,dataBroadType,factory,netElement,pointerType);
    }
}
