<%--
  Created by IntelliJ IDEA.
  User: cl
  Date: 2017/7/14
  Time: 11:43
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
    <title>数据产品</title>
    <link type="text/css" rel="stylesheet" href="../../static/dist/css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="../../static/dist/css/common.css" />
    <link type="text/css" rel="stylesheet" href="../../static/css/product.css" />

    <script type="text/javascript" src="../../static/dist/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../static/dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="../../static/dist/js/common.js"></script>
    <script type="text/javascript" src="../../static/js/functions.js"></script>
    <script type="text/javascript" src="../../static/dist/js/calendarFuntion.js"></script>
    <script src="../../static/js/product.js"></script>
</head>

<body>

<!--页头-->
<div id="header"></div>
<!--product内容部分-->
<div class="content_product">
    <%--内容上半部分，左侧图片及右侧数据选择--%>
    <div class="top_content clearfix" id="topContent"></div>
    <!--内容下半部分-->
    <div id="vm_datadesc">
        <div class="container">
            <ul id="myTab" class="nav nav-tabs">
                <li class="active">
                    <a href="#dataDetail" data-toggle="tab">数据详情</a>
                </li>
                <li><a href="#dataExample" data-toggle="tab">数据样例</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="dataDetail">
                    <%--<p>文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，。。。</p>--%>
                </div>
                <div class="tab-pane fade" id="dataExample">
                    <%--<p>文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，文本内容，。。。</p>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<!--页脚-->
<div id="footer"></div>

</body>
</html>