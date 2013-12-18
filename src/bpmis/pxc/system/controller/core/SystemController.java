package bpmis.pxc.system.controller.core;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.pxcbpmisframework.core.json.AjaxJson;
import org.pxcbpmisframework.core.util.DataToolsUtils;
import org.pxcbpmisframework.core.util.IpUtils;
import org.pxcbpmisframework.core.util.SystemPath;
import org.pxcbpmisframework.core.xml.DomjXmlIT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bpmis.pxc.system.pojo.TBEmailNotice;
import bpmis.pxc.system.pojo.TBUser;
import bpmis.pxc.system.service.SystemService;

@Controller
@RequestMapping("/systemController")
public class SystemController {
	private static final Logger logger = Logger
			.getLogger(SystemController.class);
	@Resource
	private SystemService systemService;

	/**
	 * 测试
	 */
	@RequestMapping(value = "/test.do")
	public String test(HttpServletRequest request) {
		System.out.println("----------->going le");
		systemService.saveAll(DomjXmlIT.parserITXml("2013-12-18.xml"));
		return "hello";
	}

	/**
	 * 
	 * @Title: resposEmail
	 * @Description: TODO(订阅邮件)
	 */
	@RequestMapping(value = "/noticeEmail.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson resposEmail(
			@RequestParam("emailaddress") String emailaddress,
			HttpServletRequest request) {
		AjaxJson ajx = new AjaxJson();
		TBEmailNotice tbEmailNotice = new TBEmailNotice();
		tbEmailNotice.setDatetime(DataToolsUtils.getSimpleDateFormat());
		tbEmailNotice.setEmail(emailaddress);
		tbEmailNotice.setIp(IpUtils.getLocalHostIp(request));
		tbEmailNotice.setProjectname(SystemPath.getProjectName());
		systemService.save(tbEmailNotice);
		ajx.setMsg("订阅成功，敬请期待！");
		return ajx;
	}
}
