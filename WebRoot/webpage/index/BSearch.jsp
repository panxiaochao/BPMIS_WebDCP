<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta name="description" content="Responsive business site template" />
<meta name="keywords" content="company,services,responsive,subscribe,business,marketing,corporate,ipad,iphone,site template"/>
<meta name="author" content="Tansh" />
<title>BPMIS_WebDCP</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>

<!--Fav and touch icons-->
<link rel="shortcut icon" href="<%=basePath %>img/icons/favicon.ico">
<link rel="apple-touch-icon" href="<%=basePath %>img/icons/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="<%=basePath %>img/icons/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=basePath %>img/icons/apple-touch-icon-114x114.png">

<!--style sheets-->
<link rel="stylesheet" media="screen" href="<%=basePath %>css/bootstrap.css"/>
<link rel="stylesheet" media="screen" href="<%=basePath %>css/bootstrap-responsive.css"/>
<link rel="stylesheet" media="screen" href="<%=basePath %>css/style.css"/>

<!--main jquery libraries / others are at the bottom-->
<script src="<%=basePath %>js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="<%=basePath %>js/modernizr.js" type="text/javascript"></script>
</head>
<body>
<!-- header section starts
================================================== -->
<section id="header" class="cominsoon-header">
  <div class="container clearfix">
    <div class="row"> 
      
      <!--logo starts-->
      <div class="span4 pos-rel"> <a href="index.html"><img src="<%=basePath %>img/logo1.png" width="210" height="78" alt="logo"></a>
        <div class="logo-info"></div>
      </div>
      <!--logo ends--> 
      
      <!--social starts-->
      <div class="span8">
        <ul class="social">
        </ul>
        <div class="clearfix"></div>
      </div>
      <!--social ends--> 
      
    </div>
  </div>
</section>
<!-- header section ends
================================================== --> 

<!-- content-top starts
================================================== -->
<div id="content-top">
  <div id="content-top-inner">
    <div class="container">
      <div class="row">
        <div class="span12">
          <ul class="breadcrumb">
            <li><a href="#">首页</a> <span class="divider">/</span></li>
            <li class="active">search</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- content-top ends
================================================== --> 

<!-- content starts
================================================== -->
<section id="comingsoon-search">
  <div class="container"> 
    
    <!--1.标题 -->
    <div class="row">
      <div class="search pilist">
        <ul class="nav nav-pills">
          <li><a href="#">首页</a> </li>
          <li><a href="#">新闻</a></li>
          <li class="active"><a href="#">网页</a></li>
          <li><a href="#">知道</a></li>
          <li><a href="#">音乐</a></li>
          <li><a href="#">图片</a></li>
          <li><a href="#">视频</a></li>
          <li><a href="#">地图</a></li>
          <li><a href="#">更多》</a></li>
        </ul>
      </div>
    </div>
    <!--2.搜索 -->
    <div class="row ">
      <div class="search center">
        <form class="form-search">
          <div class="input-append">
            <input type="text" class="span6 search-query">
            <button type="submit" class="btn btn-success">搜索一下</button>
          </div>
        </form>
      </div>
    </div>
    <!--3.应用 -->
    <div class="row ">
      <div class="search">
        <div class="sidebar-right"> 
          
          <!--tabs starts-->
          <ul class="nav nav-tabs" id="myTab">
            <li class="active"><a href="#A"><i class="icon-star"></i> 实时新闻</a></li>
            <li class=""><a href="#B"> <i class="icon-tags"></i> 我的标签</a></li>
            <li class=""><a href="#C">更多</a></li>
          </ul>
          <div class="tab-content"> 
            
            <!--first tab-->
            <div class="tab-pane active" id="A"> 
              
              <!--fourth post starts-->
              <div class="blogpost clearfix">
                <h4>Win9新设计：Charms菜单融入任务栏</h4>
                <ul class="breadcrumb clearfix">
                  <li>Posted : March 14, 2013 <span class="divider">/</span></li>
                  <li>By : <a href="#">guest</a> <span class="divider">/</span></li>
                  <li>Tags : <a href="#">Win 9</a>, <a href="#">marketing</a> </li>
                </ul>
                <!--Image here
          <div class="mythumb"> <img src="img/preview/blog-img3.jpg" alt="image"> </div>-->
                
                <p>尽管微软不可能现在透露Win9的重大变动，设计师们可没闲着，不断提出桌面或Modern UI的新设计。34moiso此前也设计过很多新Windows9的概念，这一次34moiso将Charm栏融入了任务栏，以期帮助用户更有效地利用Metro UI。图片显示，所有的Charm都被整齐的融入了开始菜单附近的任务栏，此前还有电源选项和其他桌面图标。该设计的唯一问题是Charm会占用任务栏的空间；某些不喜欢Modern UI的用户估计不会喜欢这个设计。希望微软在发布Win9前可以借鉴一下这些想法。消息人士称，Win9会在2015年年初发布。<a href="#">[ . . . ]</a></p>
                <a href="#" class="mybtn">Read more</a> </div>
              <div class="divider-dashed"></div>
              <!--fourth post ends--> 
              
              <!--fifth post starts-->
              <div class="blogpost clearfix">
                <h4>贪吃蛙来了，《切绳子2》19日首发iOS平台</h4>
                <ul class="breadcrumb clearfix">
                  <li>Posted : March 3, 2013 <span class="divider">/</span></li>
                  <li>By : <a href="#">admin</a> <span class="divider">/</span></li>
                  <li>Tags : <a href="#">切绳子2</a>, <a href="#">energy</a> </li>
                </ul>
                <p>切绳子（Cut the Rope）可以说是安卓、iOS以及WP8平台上最知名的一款游戏，从2010年发布以来，风靡全球的用户，近期等待三年后，切绳子2（Cut the Rope 2） 将于本月19号首发iOS平台，那只可爱的贪吃蛙又要来卖萌了。<a href="#">[ . . . ]</a></p>
                <a href="#" class="mybtn">Read more</a> </div>
              <div class="divider-dashed"></div>
              <!--fifth post ends--> 
              <!--fifth post starts-->
              <div class="blogpost clearfix">
                <h4>支付宝钱包推出12306公众服务号</h4>
                <ul class="breadcrumb clearfix">
                  <li>Posted : March 3, 2013 <span class="divider">/</span></li>
                  <li>By : <a href="#">admin</a> <span class="divider">/</span></li>
                  <li>Tags : <a href="#">支付宝</a>, <a href="#">energy</a> </li>
                </ul>
                <p>12月16日上午消息，支付宝钱包宣布开通"支付宝12306公众服务号"，为全国乘客提供包括信息公告、列车服务、订单管理等的铁路12306移动服务。还有十多天就到火车票春运发售期，不少民众都开始为购票提前做准备。如今乘客只要在支付宝钱包里添加"支付宝12306公众服务号"，火车票服务信息就可以一目了然了。<a href="#">[ . . . ]</a></p>
                <a href="#" class="mybtn">Read more</a> </div>
                <div class="divider-dashed"></div>
              <!--fifth post ends--> 
              
            </div>
            
            <!--second tab-->
            <div class="tab-pane" id="B">
              <ul class="list-checkmark">
                <li>App development</li>
                <li>Software development</li>
                <li>Graphic design</li>
                <li>Web marketing analysis</li>
              </ul>
            </div>
            
            <!--third tab-->
            <div class="tab-pane" id="C"> </div>
          </div>
          <!--tabs ends--> 
          <!--spacer here-->
          <div class="spacer-40px"></div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- content ends
================================================== --> 

<!-- footer starts
================================================== -->
<div id="footer">
  <div class="container">
    <div class="row"> 
      
      <!--first column starts-->
      <div class="span9"> 
        
        <!--row for nested columns starts-->
        <div class="row"> 
          
          <!--first nested column starts-->
          <div class="span3">
            <h5>关于WebDCP</h5>
            <p>WebDCP是一个依赖于BPMIS主程序的一个附属程序，主要是一款Web平台的个人云文档系统，这次最大的更新是采用了最新的Spring MVC架构，而且在其设计的方面，加入了混合编程方式，更加的适应扩展、适应环境！</p>
          </div>
          
          <!--second nested column starts-->
          <div class="span3">
            <h5>社交应用</h5>
            <div id="twitter"></div>
            <a href="#" class="tweet-birdy">Follow us</a></div>
          
          <!--third nested column starts-->
          <div class="span3">
            <h5>相关链接</h5>
            <ul class="list-arrow">
              <li><a href="#">BPMIS_CMS</a></li>
              <li><a href="#">BPMIS_WebDCP</a></li>
            </ul>
          </div>
        </div>
        <!--row for nested columns ends--> 
        
        <!--divider here-->
        <div class="divider-dark"></div>
        <p class="pull-left">Copyright © 2013-2014 BPMIS_WebDCP - Powered By <a href="#">Panxiaochao</a> V1.0 All Rights Reserved.</p>
        <ul class="inline-right">
          <li><a href="#">技术支持</a></li>
          <li><a href="#">隐私政策</a></li>
          <li><a href="#">版本说明</a></li>
        </ul>
      </div>
      <!--first column ends--> 
      
      <!--second column starts-->
      <div class="span3 pos-rel"> 
        <!--box-dark starts-->
        <div class="box-dark">
          <h4>Address：</h4>
          <address>
          WebDCP Inc.<br/>
          中国浙江省杭州市<br/>
          xxxxxxxxxxxxxxxxxx<br/>
          POST：310000
          </address>
        </div>
        <!--box-dark ends--> 
        
      </div>
      <!--second column ends--> 
      
    </div>
  </div>
</div>
<!-- footer ends
================================================== --> 

<!--other jqueries required--> 
<script src="<%=basePath %>plugin/bootstrap/js/bootstrap.js" type="text/javascript" ></script> 
<script src="<%=basePath %>js/custom.js" type="text/javascript"></script>
</body>
</html>