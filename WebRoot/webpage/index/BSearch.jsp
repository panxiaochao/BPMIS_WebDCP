<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta name="description" content="" />
<meta name="keywords" content=""/>
<meta name="author" content="panxiaochao" />
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
<script src="<%=basePath %>js/jquery-1.8.2.min.js" type="text/javascript" ></script>
<!--iCheck-->
<link href="<%=basePath %>plugin/iCheck/skins/square/green.css" rel="stylesheet">
<script src="<%=basePath %>plugin/iCheck/skins/icheck.js"></script>
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

<!-- content starts
================================================== -->
<section id="comingsoon-search">
  <div class="container"> 
    
    <!--1.标题 -->
    <div class="row">
      <div class="search pilist">
        <ul class="nav nav-pills">
          <li><a href="#">首页</a> </li>
          <li class="active"><a href="#">新闻</a></li>
          <li class="disabled"><a href="#">网页</a></li>
          <li class="disabled"><a href="#">知道</a></li>
          <li class="disabled"><a href="#">音乐</a></li>
          <li class="disabled"><a href="#">图片</a></li>
          <li class="disabled"><a href="#">视频</a></li>
          <li class="disabled"><a href="#">地图</a></li>
          <li class="disabled"><a href="#">更多》</a></li>
        </ul>
      </div>
    </div>
    <!--2.搜索 -->
    <div class="row ">
      <div class="search center">
        <form class="form-search">
          <div class="input-append">
            <input type="text" class="span6 search-query" placeholder="本功能不在此版本中，仅供预览" />
            <button type="submit" class="btn btn-success">搜索一下</button>
          </div>
        </form>
      </div>
    </div>
    <div class="row center">
      <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>公告：您现在使用的是BPMIS的公测版 V 1.0.0，功能灰常之简单，没有任何的花哨，这只是一个开端，在后续的版本中，会陆续的加入一些元素，慢慢的成长。期间出现的错误在所难免，所以我们离不开您的支持与建议！</strong></div>
      <div class="alert alert-error">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>建议使用Chrome，IE 8.0以上使用，效果更加！</strong></div>
    </div>
    <!--3.应用 -->
    <div class="row ">
      <div class="search">
        <div class="sidebar-right"> 
          
          <!--tabs starts-->
          <ul class="nav nav-tabs" id="myTab">
            <li class="active"><a href="#A" id="tab_new"><i class="icon-list"></i> 实时新闻</a></li>
            <li class=""><a href="#B" id="tab_tag"><i class="icon-tags"></i> 我的标签</a></li>
            <li class=""><a href="#C" id="tab_fig"><i class="icon-wrench"></i> 网站设置</a></li>
          </ul>
          <div class="tab-content">
            <div class="row" id="loading"><img src="img/loader.gif" />&nbsp;&nbsp;加载中……</div>   
            <div id="emptytext" class="row center"></div>
            
                 
            <!--first tab-->
            <div class="tab-pane active" id="A"> 
              <div class="row loading" id="A_loading"><img src="img/loader.gif" />&nbsp;&nbsp;加载中……</div>
              <input type="hidden" name="tab-paneA" id="tab-paneA" value="0" />
              <!--  
              <div class="refreshnews"><button class="btn btn-success" onclick="page('');">刷新</button></div>	
              -->
              <div id="tab-paneAtext" class="row center">
            	<div class="alert alert-info">
                <strong>没有RSS信息，我们正在导入，请稍等！</strong></div>
              </div> 
              
              <!--内容--> 
            </div>
            
            <!--second tab-->
            <div class="tab-pane " id="B">
              <div class="row loading" id="B_loading"><img src="img/loader.gif" />&nbsp;&nbsp;加载中……</div>
              <input type="hidden" name="tab-paneB" id="tab-paneB" value="0" />
              <div id="tab-paneBtext" class="row center">
              <div class="alert alert-info">
                <strong>没有自己的标签，赶快添加吧！</strong></div>
              </div>
              <blockquote>
                <p>系统 <span class="color">推荐区</span></p>
              </blockquote>
              <div class='posttag clearfix'>
                <div class="titlebox color_d"> <span class="titleicon"><a href="#" title="链接"><img src="img/icons/icon-link.png" alt="image"></a></span>
                  <p title="sssss">博客园</p>
                </div>
                <div class="titlebox color_d"><span class="titleicon"><a href="#" title="More info"><img src="img/icons/icon-link.png" alt="image"></a></span>
                  <p>CSDN</p>
                </div>
                <div class="titlebox color_d"><span class="titleicon"><a href="#" title="More info"><img src="img/icons/icon-link.png" alt="image"></a></span>
                  <p>新浪区</p>
                </div>
              </div>
              <blockquote>
                <p>我的 <span class="color">标签区</span><span class="pull-right"><a href="#addtagModal" class="pxcbtn" data-toggle="modal" data-backdrop="static">添加标签</a></span></p>
              </blockquote>
              <div class='myposttag clearfix'>
                
              </div>
            </div>
            
            <!--third tab-->
            <div class="tab-pane " id="C">
              <div class="row loading" id="C_loading"><img src="img/loader.gif" />&nbsp;&nbsp;加载中……</div>
              <input type="hidden" name="tab-paneC" id="tab-paneC" value="0" />
              <div class="row emptytext">
                <div class="alert alert-info hide" id="emptytext_C"></div>
              </div>
              <!--  
              <blockquote>
                <p>抓取时间定制 <span class="color">策略</span></p>
              </blockquote>
              <div class='sysconfigtag'>
                <div class="sysconfigtagbox">
                  <label>
                    <input type="radio" name="sysconfigtag_time" value="0" checked="checked">
                   	 每30分钟 </label>
                </div>
                <div class="sysconfigtagbox">
                  <label>
                    <input type="radio" name="sysconfigtag_time" value="1">
                                                     每45分钟 </label>
                </div>
                <div class="sysconfigtagbox">
                  <label>
                    <input type="radio" name="sysconfigtag_time" value="2">
                                                     每1小时 </label>
                </div>
                <div class="sysconfigtagbox">
                  <label>
                    <input type="radio" name="sysconfigtag_time" value="3">
                                                     每2小时</label>
                </div>
                <div class="sysconfigtagbox">
                  <label>
                    <input type="radio" name="sysconfigtag_time" value="4">
                                                      每3小时 </label>
                </div>
              </div>
              
              <div class="buttonbox">
                <button class="btn btn-success" onClick="removeRTag()">保存设置</button>
              </div>-->
              <blockquote>
                <p>管理我的 <span class="color">标签</span></p>
              </blockquote>
              <div class='sysconfigtag two'>
               
              </div>
              <div class="buttonbox">
                <button class="btn btn-success" onClick="removeCTag()">移除标签</button>
              </div>
            </div>
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
      <div class="span12"> 
        
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
          
          <!--third nested column starts-->
          <div class="span3">
            <!--box-dark starts-->
            <div class="box-dark">
              <h4>Address：</h4>
              <address>
              WebDCP Inc.<br/>
		              中国浙江省杭州市<br/>
		              西湖区天目山路财神殿81号3602<br/>
              POST：310000
              </address>
            </div>
            <!--box-dark ends--> 
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
      
      
    </div>
  </div>
</div>
<!-- footer ends
================================================== --> 
<!-- Modal -->
<div id="addtagModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">添加标签</h3>
  </div>
  <div class="modal-body">
  	<div id="addtagModal_text">
    <label>请键入您需要订阅的 Feed 地址.</label>
    <input type="text" placeholder="Feed 地址" class="span5" name="feedurl" id="feedurl" value=""/>
    <span class="help-block">例如：http://www.xxxx.com/rss/</span> 
   	</div>
   	<div class="loading" id="loading"><img src="img/loader.gif" />&nbsp;&nbsp;第一次添加Feed，正在首次配置中……</div>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    <button class="btn btn-success" id="addtag">保存</button>
  </div>
</div>
<a href='#loadingModel' data-toggle='modal'></a>
<!--other jqueries required--> 
<script src="<%=basePath %>plugin/bootstrap/js/bootstrap.js" type="text/javascript" ></script> 
<script src="<%=basePath %>js/custom.js" type="text/javascript"></script> 
<script src="<%=basePath %>plugin/jquery-scrollup/js/jquery.scrollUp.js"></script> 
<script type="text/javascript">
$(function(){
	/*
	 * @title 我的标签点击获取
	 */
	$("#tab_tag").click(function(){
		var url = "<%=basePath %>systemController/addSelfTag.do";
		var tabpaneB = $("#tab-paneB");
		if(tabpaneB.val()!=1){
			_ajaxCall(url, {feedurl: ""}, function(data){				
				$.each(data.list,function(i, rss){ 		
					var html = "<div class='titlebox'>"
						+"<span class='titleicon'><a href='"+rss.feedurl+"' target='_blank' title='"+rss.tagname+"'><img src='img/icons/icon-link.png' title='"+rss.tagname+"'></a></span>"
						+"<p>"+rss.tagname+"</p>"
						+"</div>";	
					$(".myposttag").append(html);
		        });
				//console.log(data.list);
				if(data.list.length == 0){
					$("#tab-paneBtext").show();
				}else{
					$("#tab-paneBtext").hide();
					$("html,body").animate({scrollTop: 116}, 500);
				}
				$("#B_loading").hide();
				tabpaneB.val("1");				
			}, "json", false, {loading: "#B_loading", emptytext: "#tab-paneBtext"});
		}
	});
	/*
	 * @title 添加新的标签
	 */
	$("#addtag").click(function(){
		var url = "<%=basePath %>systemController/addSelfTag.do";
		var fedurl = $("#feedurl");
		var tabpaneC = $("#tab-paneC");
		if(fedurl.val() == ""){
			fedurl.addClass("error");
		}else{
			tabpaneC.val("0");
			changeLoading("#addtagModal");
			_ajaxCall(url, {feedurl: fedurl.val()}, function(data){
				var html = "<div class='titlebox'>"
					+"<span class='titleicon'><a href='"+data.list.feedurl+"' target='_blank' title='"+data.list.tagname+"'><img src='img/icons/icon-link.png' alt='"+data.list.tagname+"'></a></span>"
					+"<p>"+data.list.tagname+"</p>"
					+"</div>";					
				$(".myposttag").append(html);							       
				$("#tab-paneBtext").hide();
				$("html,body").animate({scrollTop: 116}, 500);
				fedurl.val("");
				closemodal("#addtagModal");
				addrefreash("#A");
			}, "json", false, {modal: "#addtagModal", emptytext: "#tab-paneBtext"});
			//$("#tab_fig").trigger("click");
		}		
	});
	
	/*
	 * tab_C
	 */ 
	$('.sysconfigtag input').iCheck({
		checkboxClass: 'icheckbox_square-green',
		radioClass: 'iradio_square-green',	
		increaseArea: '20%' // optional
	});
	$("#tab_fig").click(function(){
		var url = "<%=basePath %>systemController/addSelfTag.do";
		var tabpaneC = $("#tab-paneC");
		var $emptytext_C = $("#emptytext_C");
		if(tabpaneC.val()!=1){
			_ajaxCall(url, {feedurl: ""}, function(data){
				$(".two").html("");
				$.each(data.list,function(i, rss){ 		
					var html = "<div class='sysconfigtagbox'>"
                  		+"<label><input type='checkbox' name='sysconfigtag_mytag' value='"+rss.id+"'> " 
                  		+rss.tagname+"</label>"
                		+"</div>";	
					$(".two").append(html);
		        });
				//console.log(data.list);
				if(data.list.length == 0){
					$emptytext_C.html("<strong>没有自己的标签，赶快添加吧！</strong>");
				}else{
					$emptytext_C.hide();
					$("html,body").animate({scrollTop: 116}, 500);
					$('.sysconfigtag input').iCheck({
						checkboxClass: 'icheckbox_square-green',
						radioClass: 'iradio_square-green',	
						increaseArea: '20%' // optional
					});
				}
				$("#C_loading").hide();
				tabpaneC.val("1");				
			}, "json", false, {loading: "#C_loading", emptytext: "#emptytext_C"});
		}
	});
	
});

/*
 * @title 时事新闻刷新
 */
var currentNum="";
page("");
function page(currentNum){
	var url = "<%=basePath %>systemController/tabnews.do";
	_ajaxCall(url, {pageNum: currentNum, rows: "10"}, function(data){
		var $blogpost = $(".blogpost").siblings();
		if($blogpost.length != 0)
			$blogpost.remove();
		
		$.each(data.list,function(i, rss){ 		
			var html = "<div class='blogpost clearfix'>"			
                /*+"<h4>"+rss.etitle+"</h4>"
                +"<ul class='breadcrumb clearfix'>"
                +"<li>发表时间 : "+rss.epubDate+" <span class='divider'>/</span></li>"
                +"<li>摘录者 : <a href='#'>"+rss.poster+"</a> <span class='divider'>/</span></li>"
                +"<li>来源 : <a href='"+rss.sourceUrl+"' target='_blank'>"+rss.source+"</a> <span class='divider'>/</span></li>"
                +"<li>标签 : <a href='#'>空</a> </li>"
                +"</ul>"*/
                +"<blockquote>"
                +"<p>"+rss.etitle+"</p>"
                +"<small>发表时间 : "+rss.epubDate+" <span class='divider'>&nbsp;&nbsp;/&nbsp;&nbsp;</span> 摘录者 : <a href='#'>"+rss.poster+"</a>"
				+"<span class='divider'>&nbsp;&nbsp;/&nbsp;&nbsp;</span> 来源 : <a href='"+rss.sourceUrl+"' target='_blank'>"+rss.source+"</a>" 
				+"</small>"
                +"</blockquote>"
                +"<p><b>简介：</b>"+rss.edescription+"<a href='"+rss.elink+"' target='_blank'>&nbsp;[ . . . ]</a></p>"
                +"<a href='"+rss.elink+"' target='_blank' class='mybtn'>阅读更多</a> </div>"
                +"<div class='divider-dashed'></div>";			
			$("#A").append(html);
        });
		//console.log(data.list.length);
		if(data.list.length == 0){
			$("#tab-paneAtext").show();
		}
		else{
			$("#tab-paneAtext").hide();
			$(".divider-dashed:last").after(data.pagehtml);
			$("html,body").animate({scrollTop: 116}, 500);
		}
		//window.setTimeout(function () { 
			$("#A_loading").hide();							
		//}, 1500);
						
	}, "json", false, {loading: "#A_loading",emptytext: "#tab-paneAtext"});
}
/*
 * @title 过2分钟出现刷新按钮
 */
refreash();
function refreash(){
	addrefreash('#A');
	setTimeout("refreash()",15*1000);
}

/*
 * @title 网站设置
 */
 //我的标签
function removeCTag(){
	var $checkbox = $("input[name=sysconfigtag_mytag]:checked");
	var $emptytext_C = $("#emptytext_C");
	var tabpaneB = $("#tab-paneB");//获取参数
	var tabpaneC = $("#tab-paneC");
	if($checkbox.length){
		//tabpaneB.val("0");
		tabpaneC.val("0");
		var idstr = "";
		for(var i = 0;i<$checkbox.length;i++){
			var check = $checkbox[i];
			idstr += check.value + ";";
			//console.log("值为："+check.value)
		}
		console.log($(".myposttag .titlebox").length);
		var url = "<%=basePath %>systemController/deleteTag.do";
		LoadingModel("正在删除你所选的标签，正在重新配置中，期间请不要任何操作！");
		$("#loadingModel").modal('show');
		_ajaxCall(url, {tagid: idstr}, function(data){
			var $blogpost = $(".myposttag .titlebox");
			$blogpost.remove();
			//$checkbox.remove();			
			$.each(data.list,function(i, rss){ 		
				var html = "<div class='titlebox'>"
						+"<span class='titleicon'><a href='"+rss.feedurl+"' target='_blank' title='"+rss.tagname+"'><img src='img/icons/icon-link.png' title='"+rss.tagname+"'></a></span>"
						+"<p>"+rss.tagname+"</p>"
						+"</div>";	
				$(".myposttag").append(html);
	        });				
		}, "json", false, {});
		closeModalLoading();
		$emptytext_C.hide();
		$("#tab_fig").trigger("click");
	}else{
		if($("input[name=sysconfigtag_mytag]").length == 0)
			$emptytext_C.html("<strong>【管理我的标签】没有标签，请添加标签后再操作！</strong>");
		else
			$emptytext_C.html("<strong>【管理我的标签】至少选择一个，亲！</strong>");		
		$emptytext_C.show();
	}	
}
function removeRTag(){
	var $ridaobox = $("input[name=sysconfigtag_time]:checked");
	var $emptytext_C = $("#emptytext_C");
	
	if($ridaobox.length){
		console.log("值为："+$ridaobox[0].value)
		$emptytext_C.hide();
	}else{
		$emptytext_C.html("<strong>【抓取时间定制策略】请选择一个时间定制，亲！</strong>");
		$emptytext_C.show();		
	}
}
</script>
</body>
</html>