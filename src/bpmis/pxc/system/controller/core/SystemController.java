package bpmis.pxc.system.controller.core;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		TBUser user = new TBUser();
		user.setUsername("test");
		user.setAccount("aaaa");
		systemService.save(user);
		return "hello";
	}
}
