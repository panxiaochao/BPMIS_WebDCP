//document ready
$(document).ready(function () {
	//Tabs - In such way needs to initiate each tab
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    })	
    
    //scrollUp
    $.scrollUp({
		scrollName: 'scrollUp',
		topDistance: '300', // Distance from top before showing element (px)
		topSpeed: 500, // Speed back to top (ms)
		animation: 'fade', // Fade, slide, none
		animationInSpeed: 200, // Animation in speed (ms)
		animationOutSpeed: 200, // Animation out speed (ms)
		scrollText: '', // Text for element
		scrollImg: false,
		activeOverlay: false // Set CSS color to display scrollUp active point, e.g '#00FFFF'
	});
});

/**
 * 封装ajax，统一调用
 */

function _ajaxCall(url, params, callback, datatype, isAsync, parm) {
	var option ={
		loading: "",
		modal: "",
		emptytext: ""
	};
	option=jQuery.extend(option, parm);
	$.ajax({
		type: "POST",
		url: url,
		data: params ? params : {},	
		dataType: datatype,
		async: isAsync ? false : true,
		cache: false,
		beforeSend: function(XMLHttpRequest){
			if(option.loading != "")
				$(option.loading).show();
		},
		success: function(data) {
			if(typeof(callback) == "function")  callback(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			//请求出错处理
			$(option.emptytext).html("<div class='alert alert-error' style='text-align:left;'><strong>服务器解析出错！原因如下：<br/>"+XMLHttpRequest.status+"  "+errorThrown+"</strong></div>").show();
			if(option.loading != ""){
				$(option.loading).hide();
			}
			if(option.modal != ""){
				closemodal(option.modal);
			}
		}
	});
}
function LoadingModel(str){
	var loadinghtml =""
	    +"<div id='loadingModel' class='modal hide fade' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' data-backdrop='static'>"
  		+"<div class='modal-header'>"
   			+"<h3 id='myModalLabel'>Loading</h3>"
  		+"</div>"
  		+"<div class='modal-body'>"
  			+"<div class='row loadingModel'><img src='img/loader.gif' />&nbsp;&nbsp;"+str+"</div>"
  		+"</div>"
		+"</div>";
	var $loadingModel = $("#loadingModel");
	if($loadingModel.length==0)
		$("body").append(loadinghtml);	
	//$loadingModel.modal("show");
}
function closeModalLoading(){
	var $loadingModel = $("#loadingModel");
	$loadingModel.modal("hide");
	$loadingModel.remove();
}




/**
 * 关闭Loading
 */
function closeloading(name){
	$(name).modal("hide");
}

function closemodal(name){
	$(name).modal("hide");
	$(name+"_text").show(600);
	$(name+" .modal-footer").show(600);
	$(name+" .loading").hide(600);
}
/**
 * 换Loading
 */
function changeLoading(name){
	$(name+"_text").hide(600);
	$(name+" .modal-footer").hide(600);
	$(name+" .loading").show(600);
}

function addrefreash(name){
	if($(name+" .refreshnews").length == 0)
		$(name).prepend("<div class='refreshnews'><span>您定制的信息系统默认为您30分钟更新一次，请不要过多的进行刷新！</span><button class='btn btn-success' onclick='page();'>刷新</button></div>");
}



