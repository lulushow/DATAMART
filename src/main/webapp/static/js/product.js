/**
 * Created by cl on 2017/7/7.
 */

$(document).ready(function () {
    /*获取二级页面的传参*/
    var Request=GetRequest();
    /*数据大类英文名称，如original_4G*/
    var DataNameCH=convertLanguage(Request.GNameEN);
    /*获取数据小类类型，如PM*/
    var LargeType=Request.LargeDataType;
    /*获取厂家信息*/
    var factory=Request.factory;
    /*获取网元信息*/
    var netElement=Request.netElement;
    /*获取指标类型信息*/
    var indextype=Request.indextype;
    var SmallType=factory+"&"+netElement+"&"+indextype;
    var picURL=GetPictureURL(SmallType);
    var title_str='';
    if (factory!=="null"){
        title_str+=factory;
    }
    if (netElement!=="null"){
        if (title_str){
            title_str+="-"+netElement;
        }else {
            title_str+=netElement;
        }
    }
    if (indextype!=="null"){
        if (title_str){
            title_str+="-"+indextype;
        }else {
            title_str+=indextype;
        }
    }
    var topContent_Str='';
    topContent_Str+='<div class="pic_lef">'
        +'<img src="../../static/image/dataico/detail/'+picURL+'.png" />'
        +'</div>'
        +'<div class="cont_rig">'
        +'<div class="text_title">'
        +'<a href="#"><span>'+DataNameCH+'</span></a>-<a href="#"><span>'+LargeType+'</span></a>-<span>'+title_str+'</span>'
        +'</div>'
        +'<div class="details">'
        +'<div class="detail_box clearfix">'
        +'<div class="detail_title fl">数据介绍：</div><div class="details_instrduce fl" id="introduce"></div>'
        +'</div>'
        +'<div class="detail_box clearfix">'
        +'<div class="detail_title fl">数据价格：</div><div class="details_instrduce redColor fl">免费</div>'
        +'</div>'
        +'<div class="detail_box">'
        +'<label for="prov" class="detail_title">数据省份：</label>'
        +'<select class="prov text_input" id="prov" name="provinces">'
        +'</select>'
        +'<label for="calendar_input" class="detail_title cal">数据日期：</label>'
        +'<input type="text" class="text_input" id="calendar_input" value="'+Request.dataTime+'" />'
        +'<div id="viewCalendar"></div>'
        +'</div>'
        +'</div>'
        +'<div class="count">'
        +'<ul>'
        +'<li class="fll">'
        +'<img src="../../static/image/product/down_success.png" />'
        +'<span>已成功下载{{downloadtimes}}次</span>'
        +'</li>'
        +'<li class="fll">'
        +'<img src="../../static/image/product/collected.png" />'
        +'<span>已收藏{{marktimes}}次</span>'
        +'</li>'
        +'</ul>'
        +'</div>'
        +'<div class="download">'
        +'<button type="submit" class="down"><img src="../../static/image/product/download.png" />下载</button>'
        +'<button type="submit" class="collect"><img src="../../static/image/product/collection.png" />收藏</button>'
        +'<button type="submit" class="add_more"><img src="../../static/image/product/shopping.png">加入购物车</button>'
        +'</div>'
        +'</div>';
    $("#topContent").html(topContent_Str);
    if (factory==="null"){
        factory=null;
    }
    if (netElement==="null"){
        netElement=null;
    }
    if (indextype==="null"){
        indextype=null;
    }
    /*获取三级页面信息*/
    $.ajax({
        url:'queryProvince',
        dataType:'json',
        type:'post',
        data:{"dataType":Request.GNameEN,"dataBroadType":LargeType,"factory":factory,"netElement":netElement,"pointerType":indextype},
        async:true,
        headers:{Accept:"text/plain;charset=utf-8"},
        success:function (product) {
            /*获取数据介绍*/
            var introduceStr='';
            introduceStr=product.introduce;
            $("#introduce").html(introduceStr);
            /*获取数据省份*/
            var provinceStr='';
            var provinces=product.province.split(",");
            for (var i=0;i<provinces.length;i++){
                provinceStr+='<option>'+provinces[i]+'</option>';
            }
            $("#prov").html(provinceStr);

            /*数据样例及数据详情*/
            $("#dataDetail").html("<pre>"+toTXT(product.dataDetail)+"</pre>");
            $("#dataExample").html("<pre>"+toTXT(product.dataExample)+"</pre>");

            /*日历显示部分*/
            var calendar_str='';
            calendar_str+='<div class="Calendar">'
                +'<div id="idCalendarPre"><<</div>'
                +'<div id="idCalendarNext">>></div>'
                +'<span id="idCalendarYear">2017</span>年 <span id="idCalendarMonth">6</span>月'
                +'<table cellspacing="0">'
                +'<thead>'
                +'<tr>'
                +'<td>日</td>'
                +'<td>一</td>'
                +'<td>二</td>'
                +'<td>三</td>'
                +'<td>四</td>'
                +'<td>五</td>'
                +'<td>六</td>'
                +'</tr>'
                +'</thead>'
                +'<tbody id="idCalendar">'
                +'</tbody>'
                +'</table>'
                +'</div>';
            $("#viewCalendar").html(calendar_str);

            var cale = new Calendar("idCalendar", {
                SelectDay: new Date().setDate(),
                onSelectDay: function(o){ o.className = "onSelect"; },
                onToday: function(o){ o.className = "onToday"; },
                onFinish: function(){
                    SP("idCalendarYear").innerHTML = this.Year;
                    SP("idCalendarMonth").innerHTML = this.Month;
                    queryDate($("#prov").find("option:selected").text(), this.Year, this.Month,this.Days);
                }
            });
            /*日历前翻*/
            SP("idCalendarPre").onclick = function(){
                cale.PreMonth();
            };
            /*日历后翻*/
            SP("idCalendarNext").onclick = function(){
                cale.NextMonth();
            };
            /*input点击显示与隐藏日历*/
            $("#calendar_input").click(function () {
                $("#viewCalendar").toggle();
            });

        }
    });

});

/*查询对应省份、年、月有数据的日期，并做添加点击事件及红圈标注*/
function queryDate(province, year, month,Days) {
    $.ajax({
        url:"queryDateByPro",
        dataType:'text',
        type:'post',
        data:{"province":province,"year":year,"month":month},
        async:true,
        headers:{Accept:"text/plain;charset=utf-8"},
        success:function (dateString) {
            if(dateString){
                var dated=dateString.split(",");
                for(var i = 0; i < dated.length; i++){
                    Days[dated[i]].innerHTML = "<a href='javascript:void(0);' class='haveData' onclick='selectOne("+year+","+month+","+dated[i]+")'>" + dated[i] + "</a>";
                }
            }

        }

    });
}

/*选择日的事件函数，提示选择日期，隐藏日历*/
function selectOne(year, month, day) {
    alert("您选择的日期是："+year+"-"+month+"-"+day);
    $("#calendar_input").val(year+"-"+month+"-"+day);
    $("#viewCalendar").hide();
    return false;
}
