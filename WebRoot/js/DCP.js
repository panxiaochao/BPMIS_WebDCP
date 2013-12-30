$(function() {	
	var $spanEorror = $("<span class='text-error'></span>");		
	//验证初始化
	$('#subform').validator({ 
		theme: 'yellow_top',
		stopOnError:true,
		msgMaker: false, //不要自动生成消息
		timely: 1, //2: 启用实时验证，在输入的同时验证该字段
		fields: {
			"emailaddress": {
				rule: "邮箱名:required;email"
			}									
		},
		//验证成功
		valid: function(form) {
			//do something...
			$(form).find("input[name=emailaddress]").removeClass("error");
			$.jBox.tip("正在提交中，请稍候！", 'loading');
			noticeemail();			
		},
		//验证失败
		invalid: function(form, errors) {
			$(form).find("input[name=emailaddress]").addClass("error");			
			$spanEorror.text(errors[0]);
			$(form).find("p :first").before($spanEorror);									
		}
	});
	
	$("#emailaddress").blur(function(){
  		$(this).removeClass("error");
	});
	
});

/**
 * 封装ajax，统一调用
 */
function _ajaxCall(url, params, callback, datatype, isAsync) {
	$.ajax({
		type: "POST",
		url: url,
		data: params ? params : {},
		dataType: datatype,
		async: isAsync ? false : true,	
		cache: false,	
		beforeSend: function(XMLHttpRequest){

		},
		success: function(data) {
			if(typeof(callback) == "function")  callback(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			//请求出错处理
		}
	});
}

