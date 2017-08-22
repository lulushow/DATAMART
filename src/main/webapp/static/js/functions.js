/**
 * Created by cl on 2017/7/20.
 */
/*第二个页面较长数据小类字符串分割函数*/
function stringSplit(str) {
    if (str==="null"){
        str="不区分";
    }else if (str.length>8){
        str=str.slice(0,str.length/2)+"-"+"<br />"+str.slice(str.length/2);
    }
    return str;
}

/*第二个页面的字符串转换为接收形式，如“不区分”转化为“null”*/
function strToName(str) {
    var strs=str.split("-<br>");//
    str='';
    for (var i=0;i<strs.length;i++){
        str+=strs[i];
    }
    if (str==="不区分"){
        str="null";
    }
    return str;
}

/*获取根目录及端口号*/
function getRootPath_web() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht);
}

/*数据大类中英文转换*/
function convertLanguage(name) {
    var convertName='';
    if (name==="4G原始数据"){
        convertName="original_4G";
    }else if (name==="4G解析数据"){
        convertName="analysis_4G";
    }else if (name==="3G原始数据"){
        convertName="original_3G";
    }else if (name==="2G原始数据"){
        convertName="original_2G"
    }else if (name==="original_4G"){
        convertName="4G原始数据";
    }else if (name==="analysis_4G"){
        convertName="4G解析数据";
    }else if (name==="original_3G"){
        convertName="3G原始数据";
    }else if (name==="original_2G"){
        convertName="2G原始数据";
    }
    return convertName;
}

/*解析url地址，返回请求参数*/
function GetRequest() {
    var url = decodeURI(location.search); //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") !== -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

/*解析厂家，网元，指标类型的图片相对地址*/
function GetPictureURL(smallType) {
    var types=new Array();
    types=smallType.split("&");
    var company=types[0];
    var wangyuan=types[1];
    var zhibiao=types[2];

    var url1='',url2='',url3='';
    if (company!=="null"){
        url1="company";
    }else {
        url1="null";
    }
    if (wangyuan!=="null"){
        url2="wangyuan";
    }else {
        url2="null";
    }
    if (zhibiao!=="null"){
        url3="zhibiao";
    }else {
        url3="null";
    }
    var result=url1+"&"+url2+"&"+url3;

    return result;
}

/*跳到第一个页面*/
var host =getRootPath_web();
function turnToIndex() {
    window.location.href=encodeURI(host+"/index/toIndex.action");
}

/*跳到第二个页面*/
function turnToSecondPage(m,n) {
    var DName=document.getElementById("DName"+m).innerHTML;//数据大类中文名称
    var DNameEN=convertLanguage(DName);//数据大类英文名称
    var DType=document.getElementById("DType"+m+n).innerHTML;//数据小类，如PM
    window.location.href=encodeURI(host+"/index/toDetail.action?GTypeEN="+DNameEN+"&DataType="+DType);
}

/*跳到第三个页面*/
function turnToThirdPage(n) {
    var GName=$("#nameCH").html();//数据大类中文名称
    var GNameEN=convertLanguage(GName);

    var largType=$("#largeType").html();//数据小类类型

    var Factory=$("#factory"+n).html();//厂家
    Factory=strToName(Factory);

    var NetElement=$("#netElement"+n).html();//网元
    NetElement=strToName(NetElement);

    var indexType=$("#index"+n).html();//指标类型
    indexType=strToName(indexType);


    var DataTime=$("#datatime"+n).html();//最新数据时间

    window.location.href=encodeURI(host+"/index/toProduct.action?GNameEN="+GNameEN+"&LargeDataType="+largType+"&factory="+Factory+"&netElement="+NetElement+"&indextype="+indexType+"&dataTime="+DataTime);
}

/*Html结构转字符串形式显示 支持<br>换行*/
function toTXT(str) {
    var RexStr = /\<|\>|\"|\'|\&|　| /g
    str = str.replace(RexStr,
        function (MatchStr) {
            switch (MatchStr) {
                case "<":
                    return "&lt;";
                    break;
                case ">":
                    return "&gt;";
                    break;
                case "\"":
                    return "&quot;";
                    break;
                case "'":
                    return "&#39;";
                    break;
                case "&":
                    return "&amp;";
                    break;
                case " ":
                    return "&ensp;";
                    break;
                case "　":
                    return "&emsp;";
                    break;
                default:
                    break;
            }
        }
    )
    return str;
}