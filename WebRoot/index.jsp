<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="description" content="" />
<meta name="keywords" content=""/>
<meta name="author" content="Tansh" />
<title>BPMIS_WebDCP</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>

<!--Fav and touch icons-->
<link rel="shortcut icon" href="img/icons/favicon.ico">

<!--style sheets-->
<link rel="stylesheet" media="screen" href="css/bootstrap.css"/>
<link rel="stylesheet" media="screen" href="css/bootstrap-responsive.css"/>
<link rel="stylesheet" media="screen" href="css/style.css"/>
<link rel="stylesheet" href="plugin/validator/jquery.validator.css">
<link href="plugin/jBox/Skins2/Green/jbox.css" rel="stylesheet" />
<!--main jquery libraries / others are at the bottom-->
<script src="js/jquery-1.8.2.min.js" type="text/javascript" ></script>

</head>
<body>
<!-- header section starts
================================================== -->
<section id="header" class="cominsoon-header">
  <div class="container clearfix">
    <div class="row"> 
      
      <!--logo starts-->
      <div class="span4 pos-rel"> <a href="#"><img src="img/logo1.png" width="210" height="78" alt="logo"></a>
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
        <div class="span12 text-center">
          <h1>BPMIS_WebDCP</h1>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- content-top ends
================================================== --> 

<!-- content starts
================================================== -->
<div id="comingsoon-clouds">
  <div class="container"> 
    
    <!--row (first) starts-->
    <div class="row"> 
      
      <!--introtext image starts-->
      <div class="span12 text-center hidden-phone"><img src="img/preview/coming-info.png" alt="image"></div>
      <div class="spacer-40px"></div>
      <!--introtext image ends--> 
      
      <!--first column starts-->
      <div class="span6">
        <div class="left-blank">
          <form id="subform" method="post" action="">
            <fieldset>
              <p> <span class="text-error"></span>
                <input id="emailaddress" name="emailaddress"  type="text" placeholder="Email address">
              </p>
              <p>
                <input type="submit" value="Get me notified" class="submit"/>
              </p>
            </fieldset>
          </form>
        </div>
      </div>
      <!--first column ends--> 
      
      <!--second column starts-->
      <div class="span6">
        <div class="right-blank">
          <h5>预计发布日期是&nbsp;<span class="color">25<sup>th</sup> Dec 2013</span></h5>
          <p>目前，我们正在对我们的网站进行研发，初步模型将在2013.12.25展示，请不要忘记订阅得到的通知和我们推出的时间。 </p>
          <div class="spacer-20px"></div>
          <a href="#" class="tweet-birdy">Follow us on twitter</a>
          <div class="spacer-10px"></div>
          <div id="twitter" class="twitter-comingsoon"></div>
        </div>
      </div>
      <!--second column ends--> 
      
    </div>
    <!--row (first) ends--> 
    
  </div>
</div>
<!-- content ends
================================================== --> 

<!-- footer starts
================================================== -->
<footer id="footer">
  <div class="container">
    <div class="row comingsoon-footer"> 
      <!--first column starts-->
      <div class="span12"> <span class="pull-left">Copyright © 2013-2014 BPMIS_WebDCP - Powered By <a href="#">Panxiaochao</a> V1.0 All Rights Reserved.</span>
        <ul class="inline-right">
          <li><a href="#">技术支持</a></li>
          <li><a href="#">隐私政策</a></li>
          <li><a href="#">版本说明</a></li>
        </ul>
      </div>
    </div>
  </div>
</footer>
<!-- footer ends
================================================== --> 

<!-- validator -->

<script type="text/javascript" src="plugin/validator/jquery.validator.js"></script> 
<script type="text/javascript" src="plugin/validator/local/zh_CN.js"></script> 
<script type="text/javascript" src="js/DCP.js"></script>
<!-- jbox-->

<script src="plugin/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="plugin/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" src="js/plugin.js"></script>
<script type="text/javascript" >
function noticeemail(){	
	var url = "<%=basePath %>systemController/noticeEmail.do";
	var emailaddress = $("#emailaddress");
	_ajaxCall(url, {emailaddress: emailaddress.val()}, function(data){
		window.setTimeout(function () { 
			if(data.success){
				jtip(data.msg, "info");
				emailaddress.val("");
			}				
			else{
				emailaddress.val("");
				jtip("订阅失败！", "info");	
			}							
		}, 1000);
				
	}, "json", false);
}
</script>
</body>
</html>
