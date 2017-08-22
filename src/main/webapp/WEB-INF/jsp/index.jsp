<%--
  Created by IntelliJ IDEA.
  User: cl
  Date: 2017/7/14
  Time: 11:37
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
    <link type="text/css" rel="stylesheet" href="../../static/css/index.css" />
    <link type="text/css" rel="stylesheet" href="../../static/dist/css/common.css" />

    <script type="text/javascript" src="../../static/dist/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../static/dist/js/common.js"></script>
    <script type="text/javascript" src="../../static/js/slider.js"></script>
    <script type="text/javascript" src="../../static/js/functions.js"></script>
    <script type="text/javascript" src="../../static/js/index.js"></script>
</head>
<body>

<!--页头-->
<div id="header"></div>

<!--轮播部分-->
<div class="slider">
    <ul class="slider-main">
        <li class="slider-panel">
            <a href="#">
                <img src="../../static/image/banner/1.png" />
                <div class="banner_text">
                    <h1>通信数据产品</h1>
                    <p>数据超市提供了大量的通信数据产品，包括4G原始数据产品，4G解析数据产品，3G原始数据产品和2G原始数据产品。私有部署，数据无忧</p>
                </div>
            </a>
        </li>
        <li class="slider-panel">
            <a href="#">
                <img src="../../static/image/banner/3.png" />
                <div class="banner_text">
                    <h1>通信数据产品</h1>
                    <p>数据超市提供了大量的通信数据产品，包括4G原始数据产品，4G解析数据产品，3G原始数据产品和2G原始数据产品。私有部署，数据无忧</p>
                </div>
            </a>
        </li>
        <li class="slider-panel">
            <a href="#">
                <img src="../../static/image/banner/4.png" />
                <div class="banner_text">
                    <h1>通信数据产品</h1>
                    <p>数据超市提供了大量的通信数据产品，包括4G原始数据产品，4G解析数据产品，3G原始数据产品和2G原始数据产品。私有部署，数据无忧</p>
                </div>
            </a>
        </li>
        <li class="slider-panel">
            <a href="#">
                <img src="../../static/image/banner/5.png" />
                <div class="banner_text">
                    <h1>通信数据产品</h1>
                    <p>数据超市提供了大量的通信数据产品，包括4G原始数据产品，4G解析数据产品，3G原始数据产品和2G原始数据产品。私有部署，数据无忧</p>
                </div>
            </a>
        </li>
    </ul>
    <div class="slider-extra">
        <ul class="slider-nav">
            <li class="slider-item">1</li>
            <li class="slider-item">2</li>
            <li class="slider-item">3</li>
            <li class="slider-item">4</li>
        </ul>
        <div class="slider-page">
            <a class="slider-pre" href="javascript:void(0);">&lt;</a>
            <a class="slider-next" href="javascript:void(0);">&gt;</a>
        </div>
    </div>
</div>

<!--数据超市内容部分-->
<div class="data_content">
    <!--分割线title-->
    <div class="line">
        <span class="spanBackground"><img src="../../static/image/dataico/data.png" width="40px" height="40px" />数据超市</span>
    </div>

    <!--数据大类anchor到下面的数据大类列表-->
    <div class="pictures">
        <div class="data_picture p1">
            <div class="background">
            </div>
            <a href="#4G原始数据">
                <div class="text_view">
                    <p>4G原始数据</p>
                </div>
            </a>
        </div>
        <div class="data_picture p2">
            <div class="background">
            </div>
            <a href="#4G解析数据">
                <div class="text_view">
                    <p>4G解析数据</p>
                </div>
            </a>
        </div>
        <div class="data_picture p3">
            <div class="background">
            </div>
            <a href="#3G原始数据">
                <div class="text_view">
                    <p>3G原始数据</p>
                </div>
            </a>
        </div>
        <div class="data_picture p4">
            <div class="background">
            </div>
            <a href="#2G原始数据">
                <div class="text_view">
                    <p>2G原始数据</p>
                </div>
            </a>
        </div>
    </div>

    <%--数据大类列表--%>
    <div id="gData" class="gData">
    </div>
</div>
<!--页脚-->
<div id="footer"></div>
<!--登录对话框-->
<div id="fade"></div>
<div id="dialog"></div>



</body>
</html>