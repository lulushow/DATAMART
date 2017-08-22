/**
 * Created by cl on 2017/6/2.
 */
$(document).ready(function () {
/*获取数据大类列表信息*/
    $.ajax({
        url:'queryIndex',
        dataType:'json',
        type:'post',
        async:true,
        success:function (data) {
            var str='';

            for (var i=0;i<data.length;i++){
                str+='<div class="rowList" id="'+data[i].name+'">'
                    +'<div class="homeTitle">'
                    +'<span id="DName'+i+'">'+data[i].name+'</span>'
                    +'</div>'
                    +'<ul class="homeList">'
                    +'<li class="ad">'
                    +'<img class="list_img" src="../../static/image/dataico/'+data[i].name+'/background.png" />'
                    +'<div class="list_text">'
                    +'<p>'+data[i].name+'</p>'
                    +'<p>分类列表</p>'
                    +'</div>'
                    +'</li>';
                var addArr={datatype:'待添加',datasize:'0',datatime:'0000-00-00'};
                var len=data[i].info.length;
                while (len%4!==0){
                    len=len+1;
                    data[i].info.push(addArr);
                }
                for (var j=0;j<data[i].info.length;j++){
                    str+='<li class="list_table">'
                        +'<a href="javascript:void(0);" target="_blank" onclick="turnToSecondPage('+i+','+j+')">'
                        +'<dl class="list_dl">'
                        +'<dt class="img_border">'
                        +'<img src="../../static/image/dataico/'+data[i].name+'/'+data[i].info[j].datatype+'.png" width="40px" height="40px" />'
                        +'</dt>'
                        +'<dd class="text_bottom clearfix">'
                        +'<h3><span>'+data[i].info[j].datatype+'</span>数据大类</h3>'
                        +'<p><span class="lef">数据类型：</span><span class="rig" id="DType'+i+j+'">'+data[i].info[j].datatype+'</span></p>'
                        +'<p><span class="lef">数据大小：</span><span class="rig">'+data[i].info[j].datasize+'</span></p>'
                        +'<p><span class="lef">最新时间：</span><span class="rig">'+data[i].info[j].datatime+'</span></p>'
                        +'</dd>'
                        +'</dl>'
                        +'</a>'
                        +'</li>';
                }
                str+='</ul>'
                    +'</div>';
            }

            $("#gData").html(str);
        }
    })


});


/*function getLocalIPAddress()
{
    var obj = null;
    var rslt = "127.0.0.1";
    try
    {
        obj = new ActiveXObject("rcbdyctl.Setting");
        if (!isNull(obj.GetIPAddress))
        {
            rslt = obj.GetIPAddress;
        }
        obj = null;
    }
    catch(e)
    {
        //异常发生
    }

    return rslt;
}*/
