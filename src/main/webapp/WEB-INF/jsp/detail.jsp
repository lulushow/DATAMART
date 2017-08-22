<%--
  Created by IntelliJ IDEA.
  User: cl
  Date: 2017/7/14
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>数据超市</title>
    <link type="text/css" rel="stylesheet" href="../../static/dist/css/common.css" />
    <link type="text/css" rel="stylesheet" href="../../static/css/detail.css" />

    <script type="text/javascript" src="../../static/dist/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../static/dist/js/common.js"></script>
    <script type="text/javascript" src="../../static/js/functions.js"></script>
    <script src="../../static/js/details.js"></script>
</head>
<body>
<!--页头-->
<div id="header"></div>
<div class="main-content clearfix">
    <!--侧兰导航-->
    <div class="navigation left" id="navList">
    </div>
    <!--二级网页内容-->
    <div class="m_ct" id="detail_content">
    </div>
</div>

<!--页脚-->
<div id="footer"></div>
<!--登录对话框-->
<div id="fade"></div>
<div id="dialog"></div>
</body>
</html>