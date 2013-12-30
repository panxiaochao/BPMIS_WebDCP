package bpmis.pxc.system.controller.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.pxcbpmisframework.core.common.qbc.CriteriaQuery;
import org.pxcbpmisframework.core.common.qbc.HqlQuery;
import org.pxcbpmisframework.core.constant.Globals;
import org.pxcbpmisframework.core.htmlparser.RSSParserUtil;
import org.pxcbpmisframework.core.json.AjaxJson;
import org.pxcbpmisframework.core.page.Page;
import org.pxcbpmisframework.core.util.DataToolsUtils;
import org.pxcbpmisframework.core.util.IpUtils;
import org.pxcbpmisframework.core.util.StringUtil;
import org.pxcbpmisframework.core.util.SystemPath;
import org.pxcbpmisframework.core.xml.DomjXmlIT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bpmis.pxc.system.pojo.TBEmailNotice;
import bpmis.pxc.system.pojo.TBRss;
import bpmis.pxc.system.pojo.TBRssTag;
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
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dao.do", params = "filename")
	public String test(HttpServletRequest request, String filename) {
		System.out.println("----------->going le");
		Map<String, Object> map = DomjXmlIT.parserXml(filename);
		List<TBRss> list = (List<TBRss>) map.get("list");
		systemService.saveAll(list);
		// List link_sub = systemService
		// .queryForList("select elink from tb_rss where source = 'IT之家' order by epubDate desc");
		// for (Object str : link_sub) {
		// System.out.println(str);
		// }
		// String link = systemService
		// .queryForString("select top 1 elink from tb_rss where source = 'IT之家' order by epubDate desc");
		// System.out.println("1条记录的：" + link);
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

	/**
	 * 
	 * @Title: tab_news
	 * @Description: TODO(实时新闻)
	 */
	@RequestMapping(value = "/tabnews.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> tab_news(HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");// 当前页
		String rows = request.getParameter("rows");// 每页数据
		CriteriaQuery cq = new CriteriaQuery(false, "epubDate");
		/** --字段-- **/
		Map<Object, String> parms = HqlQuery.getHashMaps();
		parms.put("macaddr", IpUtils.getMacAddress());
		cq.setMap(parms);
		/** --字段end-- **/
		Page page = new Page();
		if ((null != pageNum && !"".equals(pageNum))
				&& (null != rows && !"".equals(rows))) {
			page.setCurrentPage(pageNum);
			page.setPageSize(rows);
		}
		Map<?, ?> mapPage = systemService.getPageList(TBRss.class, cq, page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", mapPage.get("list"));
		map.put("pagehtml", mapPage.get("pagehtml"));
		return map;
	}

	/**
	 * 
	 * @Title: tab_selftag
	 * @Description: TODO(添加自己的tag)
	 */
	@RequestMapping(value = "/addSelfTag.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> tab_selftag(HttpServletRequest request) {
		String feedurl = request.getParameter("feedurl");
		Map<String, Object> map = new HashMap<String, Object>();
		if (!"".equals(feedurl) && null != feedurl) {
			map.put("list", savetag(feedurl));
			return map;
		}
		String hql = "from TBRssTag where macaddr ='" + IpUtils.getMacAddress()
				+ "' order by createtime desc";// 采用本机上，可以看本机的信息，伪cooikes的行为

		List<TBRssTag> list = systemService.findByQueryHql(hql);
		map.put("list", list);
		return map;
	}

	@SuppressWarnings("unchecked")
	public TBRssTag savetag(String url) {
		/**
		 * ========================配置文件
		 */
		Map<String, Object> maprss = RSSParserUtil.RssHome(url);
		Map<String, Object> mapdom = DomjXmlIT.parserStringXml(maprss.get(
				"xmlcontent").toString());// 网上直接获取xml流，使用内容解析！防止存本地乱码
		List<TBRss> list = (List<TBRss>) mapdom.get("list");
		if (list.size() != 0)
			systemService.saveAll(list);
		String logcontent = "[******" + DataToolsUtils.getSimpleDateFormat()
				+ " 初次配置抓取标题为  " + mapdom.get("source") + " ，总共录入数据 "
				+ list.size() + "条******]";
		systemService.addLogger(logcontent, Globals.Logger_Leavel_INFO,
				Globals.Logger_Type_INSERT);
		/**
		 * ==================================================
		 */
		TBRssTag tag = new TBRssTag();
		tag.setFeedurl(url);
		tag.setSysfig("1");
		tag.setTagname(mapdom.get("source").toString());
		tag.setMacaddr(IpUtils.getMacAddress());
		tag.setCreatetime(DataToolsUtils.getSimpleDateFormat());
		systemService.save(tag);

		return tag;
	}

	/**
	 * 
	 * @Title: deleteTag
	 * @Description: TODO(删除tag)
	 */
	@RequestMapping(value = "/deleteTag.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteTag(HttpServletRequest request) {
		String idstr = request.getParameter("tagid");
		String[] id = StringUtil.splitString(idstr, ";");
		//systemService.deleteAll(TBRssTag.class, id, null);

		for (String string : id) {
			TBRssTag tag = (TBRssTag) systemService.getClassById(
					TBRssTag.class, string);
			List<TBRssTag> list = systemService
					.findByQueryHql("from TBRss where source = '"
							+ tag.getTagname() + "' ");
			systemService.delete(tag);
			systemService.deleteAll(list);
		}
		/*
		 * 重新获取标签返回
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from TBRssTag where macaddr ='" + IpUtils.getMacAddress()
				+ "' order by createtime desc";// 采用本机上，可以看本机的信息，伪cooikes的行为

		List<TBRssTag> list = systemService.findByQueryHql(hql);
		map.put("list", list);
		return map;
	}
}
