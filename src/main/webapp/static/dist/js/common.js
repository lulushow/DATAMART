/**
 * Created by cl on 2017/6/2.
 */
$(function () {
    var headStr = "", footStr = "";
    //var user = getCookie("username");
    var user = '';
    if (!user){
        user=null;
    }
/*页头*/
    headStr += '<div class="header clearfix">'
        +'<div class="header_nav fl">'
        +'<img src="../../../static/image/logo.png" height="50px" alt="logo" />'
        +'<span><a href="javascript:void(0);" target="_blank" onclick="turnToIndex()">首页</a></span>'
        +'<span><a href="javascript:void(0);" target="_blank" onclick="turnToSecondPage(0,0)">数据超市</a></span>'
        +'</div>'
        +'<div class="header_login fl">'
        +'<span id="login_span" class="login_span"><a href="javascript:void(0);" id="login">登录</a></span>'
        +'</div>'
        +'</div>';

    //登录部分：
    var loginStr='';

    loginStr +='<div class="login_head">'
        +'<button type="button" class="close" id="close"><img src="../../../static/image/login/close.png" width="20px" height="20px" /></button>'
        +'<div class="welcome">'
        +'<span>X</span>欢迎登录数据超市'
        +'</div>'
        +'</div>'
        +'<form class="login_form">'
        +'<div class="username input_div">'
        +'<label for="name"><img src="../../../static/image/login/user.png" width="40px" height="40px" /></label>'
        +'<input type="text" id="name" placeholder="您的手机号码" />'
        +'<div class="margin">'
        +'<div id="nameTip" class="red"></div> '
        +'</div>'
        +'</div>'
        +'<div class="passwords input_div">'
        +'<label for="password"><img src="../../../static/image/login/password.png" width="40px" height="40px" /></label>'
        +'<input type="password" id="password" placeholder="您的密码" />'
        +'<div class="margin">'
        +'<div id="passwordTip" class="red"></div> '
        +'</div>'
        +'</div>'
        +'<div class="input_div">'
        +'<div class="margin">'
        +'<input type="submit" id="submit" class="submit" value="登  录" />'
            +'<div id="msg" class="red"></div> '
        +'</div>'
        +'</div>'
        +'</form>';


    //页脚
    footStr +='<div class="foot_content clearfix">'
        +'<ul class="foot_ul intros">'
        +'<li class="box_title"><img src="../../../static/image/foot/aboutme.png" width="30px" height="30px">关于我们</li>'
        +'<li class="ul_content"><a href="#"><p>团队介绍</p></a></li>'
        +'<li class="ul_content"><a href="#"><p>团队成员</p></a></li>'
        +'</ul>'
        +'<ul class="foot_ul intros">'
        +'<li class="box_title"><img src="../../../static/image/foot/contactme.png" width="30px" height="30px">联系我们</li>'
        +'<li class="ul_content clearfix"><p class="box_subtitle fl">地址：</p><p class="box_subcontent fl">北京市海淀区首体南路9号主语国际3号楼</p></li>'
        +'<li class="ul_content clearfix"><p class="box_subtitle fl">电话：</p><p class="box_subcontent fl">010-68799999（转）7594</p></li>'
    +'<li class="ul_content clearfix"><p class="box_subtitle fl">邮箱：</p><p class="box_subcontent fl">magiclake_service@163.com</p></li>'
    +'<li class="ul_content clearfix"><p class="box_subtitle fl">邮编：</p><p class="box_subcontent fl">100048</p></li>'
    +'</ul>'
        +'<ul class="foot_ul QRcode_box">'
        +'<li class="box_title"><img src="../../../static/image/foot/followme.png" width="30px" height="30px">关注我们</li>'
        +'<li class="ul_content"><img src="../../../static/image/gongzhonghao_117.jpg" /></li>'
        +'</ul>'
    +'</div>';


    $("#header").html(headStr);
    $("#dialog").html(loginStr);
    $("#login").click(function () {
        $("#fade").show();
       $("#dialog").show();
    });
    $("#close").click(function () {
        $("#dialog").hide();
        $("#fade").hide();
    });

    /*输入用户名格式验证*/
    $("input#name").blur(function () {
       if ((!$(this).val())){
           $("#nameTip").html("用户名不能为空");
       } else if(!$(this).val().match(/^1[3|4|5|8][0-9]\d{4,8}$/)){
           $("#nameTip").html("用户名不正确，且只能为手机号码");
       } else {
           $("#nameTip").html("");
       }
    });
    /*密码验证*/
    $("input#password").blur(function () {
        if (!$(this).val()){
            $("#passwordTip").html("密码不能为空");
        }
    });
    $("#submit").click(function () {
        if (checkInput()){
            user=$("input#name").val();
            $("#dialog").hide();
            $("#fade").hide();
            $("#login_span").html("<span>欢迎</span>"+user);
        }else{
            $("#msg").html("用户名或密码错误")
            return false;
        }
    });
    $("#footer").html(footStr);
});

/*输入用户名与密码匹配验证函数*/
function checkInput() {
    if ($("input#name").val()==="18811567815" && $("input#password").val()==="123456"){
        return true;
    }else{
        return false;
    }
}
