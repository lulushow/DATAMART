/**
 * Created by cl on 2017/7/11.
 */


$(document).ready(function () {
    var url=location.href;

    /*获取侧兰*/
    $.ajax({
        url:"queryIndex",
        dataType:"json",
        type:"post",
        async:true,
        success:function (data) {
            var nav_str='';
            for (var i=0;i<data.length;i++){
                nav_str+='<div class="nav_box">'
                    +'<h2 id="name'+i+'">'+data[i].name+'</h2>'
                    +'<ul>';
                for (var j=0;j<data[i].info.length;j++){
                    nav_str+='<li class="u_tab" id="list'+i+j+'" onclick="setTab('+data.length+','+data[i].info.length+','+i+','+j+')">'+data[i].info[j].datatype+'</li>';
                }
                nav_str+='</ul>'
                    +'</div>';
            }
            $("#navList").html(nav_str);
            var Request=GetRequest();
            /*为侧兰点击事件添加active class*/
            for (var m=0;m<data.length;m++){
                for (var n=0;n<data[m].info.length;n++){
                    var menu = document.getElementById("list" + m+n);
                    if ($("#name"+m).html()===convertLanguage(Request.GTypeEN) && $("#list"+m+n).html()===Request.DataType){
                        $("#list"+m+n).addClass("active");
                    }else {
                        $("#list"+m+n).addClass("active");
                        $("#list"+m+n).removeClass("active");
                    }
                }
            }
            fun(Request.GTypeEN,Request.DataType);
        }
    })
});

/*侧兰点击事件*/
function setTab(M,N,m,n) {
    /*为侧兰点击事件添加active class*/
    for (var i=0;i<M;i++){
        for (var j=0;j<N;j++){
            var menu = document.getElementById("list" + i+j);
            if (i===m && j===n){
                $("#list"+i+j).addClass("active");
            }else {
                $("#list"+i+j).addClass("active");
                $("#list"+i+j).removeClass("active");
            }
        }
    }
    var nameCH=document.getElementById("name"+m).innerHTML;
    var nameEN=convertLanguage(nameCH);
    var large_type=document.getElementById("list"+m+n).innerHTML;
    fun(nameEN,large_type);
}

/*右侧内容获取函数*/
function fun(nameEN,large_type) {
    var nameCH=convertLanguage(nameEN);

    $.ajax({
        url:'queryBroadData',
        data:{"dataType":nameEN,"dataBroadType":large_type},
        type:'post',
        dataType:'json',
        async:true,
        success:function (info_detail) {

            var detail_str='';
            detail_str+='<div class="right active1">'
                +'<div class="right_nav">'
                +'<a href="#" id="nameCH">'+nameCH+'</a><span>&gt;</span><span id="largeType">'+large_type+'</span>'
                +'<span>共找到服务</span><span>'+info_detail.length+'</span><span>个</span>'
                +'</div>'
                +'<div class="content_box clearfix">';
            for (var k=0;k<info_detail.length;k++){
                var type=info_detail[k].category;
                var types=new Array();
                types=type.split("&");
                var company=types[0];
                var wangyuan=types[1];
                var zhibiao=types[2];
                var dataURL=GetPictureURL(type);

                var dataType='';
                detail_str+= '<div class="data_content">'
                    +'<a href="javascript:void(0);" target="_blank" onclick="turnToThirdPage('+k+')">'
                    +'<dl class="data_dl">'
                    +'<dt class="data_dt">'
                    +'<img src="../../static/image/dataico/detail/'+dataURL+'.png" width="80px" height="80px" />'
                    +'</dt>'
                    +'<dd class="data_dd">'
                    +'<div><span class="lef">数据厂家：</span><span class="rig" id="factory'+k+'">';

                /*分割较长字符串，及对null字符串显示“不区分”*/
                company=stringSplit(company);
                wangyuan=stringSplit(wangyuan);
                zhibiao=stringSplit(zhibiao);

                detail_str+=company+'</span></div>'
                    +'<div><span class="lef">数据网元：</span><span class="rig" id="netElement'+k+'">'
                    +wangyuan+'</span></div>'
                    +'<div><span class="lef">指标类型：</span><span class="rig" id="index'+k+'">'
                    +zhibiao+'</span></div>'
                    +'<div><span class="lef">数据大小：</span><span class="rig">'+info_detail[k].datasize+'</span></div>'
                    +'<div><span class="lef">数据时间：</span><span class="rig" id="datatime'+k+'">'+info_detail[k].datatime+'</span></div>'
                    +'<div style="display: none"><span class="lef">数据简介：</span><span class="rig" id="introduce'+k+'">'+info_detail[k].introduce+'</span></div>'
                    +'</dd>'
                    +'</dl>'
                    +'</a>'
                    +'</div>';
            }
            detail_str+='</div></div>';
            $("#detail_content").html(detail_str);
        }
    });
}


