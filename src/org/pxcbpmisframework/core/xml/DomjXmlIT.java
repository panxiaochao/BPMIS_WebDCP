package org.pxcbpmisframework.core.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.pxcbpmisframework.core.constant.Globals;
import org.pxcbpmisframework.core.exception.BusinessException;
import org.pxcbpmisframework.core.htmlparser.RSSParserUtil;
import org.pxcbpmisframework.core.util.DataToolsUtils;
import org.pxcbpmisframework.core.util.IpUtils;
import org.pxcbpmisframework.core.util.SpringContextHolder;

import bpmis.pxc.system.pojo.TBRss;
import bpmis.pxc.system.service.SystemService;

public class DomjXmlIT {
	private static final Logger logger = Logger.getLogger(DomjXmlIT.class);
	private static String path = "E://index//";
	private static SystemService systemService = SpringContextHolder
			.getBean(SystemService.class);

	/**
	 * @Description: TODO(从文件读取XML，输入文件名，返回XML文档)
	 */
	public Document read(String fileName) throws MalformedURLException,
			DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path + fileName));
		return document;
	}

	/**
	 * @Description: TODO(返回根节点)
	 */
	public Element getRootElement(Document doc) {
		return doc.getRootElement();
	}

	/**
	 * @Description: TODO(ITHome 采用地址解析，返回的xml，并将其存入数据库)
	 */
	@SuppressWarnings( { "deprecation", "static-access" })
	public static Map<String, Object> parserXml(String filename) {
		Document document = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			document = new DomjXmlIT().read(filename);
			// document.setXMLEncoding("UTF8");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			new BusinessException(e.getMessage());
		}
		Element root = document.getRootElement();
		List<TBRss> listElement = new ArrayList<TBRss>();
		String pubdate = "", nowtime = DataToolsUtils
				.SimpleFormatTime("yyyy-MM-dd");
		boolean flag = true;
		for (Iterator<?> iter = root.elementIterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			String source = element.element("title").getText();
			String sourceDescription = element.element("description").getText();
			String sourceUrl = element.element("link").getText();
			String link_sub = systemService
					.queryForString("select top 1 elink from tb_rss where source = '"
							+ source + "' order by epubDate desc");
			System.out.println(link_sub);
			map.put("source", source);
			for (Iterator<?> item = element.elementIterator("item"); item
					.hasNext();) {
				Element node = (Element) item.next();
				pubdate = DataToolsUtils.longParseStr(new Date().parse(node
						.element("pubDate").getText().toString()));

				if (pubdate.substring(0, 10).equals(nowtime)) {
					System.out.println("-------------》属于今天新闻！");
					if (link_sub == null) {
						System.out.println("属于可录入新闻！");
						TBRss tbrss = new TBRss();
						tbrss.setCreatetime(DataToolsUtils
								.getSimpleDateFormat());
						tbrss.setPoster("panxiaochao");
						tbrss.setSource(source);
						tbrss.setSourceDescription(sourceDescription);
						tbrss.setSourceUrl(sourceUrl);
						tbrss.setEtitle(node.element("title").getText());
						tbrss.setElink(node.element("link").getText());
						tbrss.setEdescription(node.element("description")
								.getText());
						tbrss.setEpubDate(pubdate);
						listElement.add(tbrss);
					} else {
						if (!node.element("link").getText().equals(link_sub)
								&& flag) {
							System.out.println("属于可录入新闻！");
							TBRss tbrss = new TBRss();
							tbrss.setCreatetime(DataToolsUtils
									.getSimpleDateFormat());
							tbrss.setPoster("panxiaochao");
							tbrss.setSource(source);
							tbrss.setSourceDescription(sourceDescription);
							tbrss.setSourceUrl(sourceUrl);
							tbrss.setEtitle(node.element("title").getText());
							tbrss.setElink(node.element("link").getText());
							tbrss.setEdescription(node.element("description")
									.getText());
							tbrss.setEpubDate(pubdate);
							listElement.add(tbrss);
						} else {
							flag = false;
							System.out.println("-------------》新闻重复，拒绝录入！");
						}
					}

				}
			}
		}
		System.out.println("总共录入新闻" + listElement.size() + "条！");
		map.put("list", listElement);
		return map;

	}

	/**
	 * @Description: TODO(ITHome 采用StringXML解析，返回的xml，并将其存入数据库)
	 */
	@SuppressWarnings( { "deprecation", "static-access" })
	public static Map<String, Object> parserStringXml(String content) {
		Document document = null;
		SAXReader saxReader = new SAXReader();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			document = saxReader.read(new StringReader(content));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			new BusinessException(e.getMessage());
		}
		Element root = document.getRootElement();
		List<TBRss> listElement = new ArrayList<TBRss>();

		String pubdate = "", nowtime = DataToolsUtils
				.SimpleFormatTime("yyyy-MM-dd"), macaddr = IpUtils
				.getMacAddress();
		boolean flag = true;
		for (Iterator<?> iter = root.elementIterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			String source = element.element("title").getText();
			String sourceDescription = element.element("description").getText();
			String sourceUrl = element.element("link").getText();
			String link_sub = systemService
					.queryForString("select top 1 elink from tb_rss where source = '"
							+ source + "' order by epubDate desc");

			map.put("source", source);
			for (Iterator<?> item = element.elementIterator("item"); item
					.hasNext();) {
				Element node = (Element) item.next();
				pubdate = DataToolsUtils.longParseStr(new Date().parse(node
						.element("pubDate").getText().toString()));
				if (pubdate.substring(0, 10).equals(nowtime)) {
					System.out.println("-------------》属于今天新闻！");
					if (link_sub == null) {
						System.out.println("属于可录入新闻！");
						TBRss tbrss = new TBRss();
						tbrss.setCreatetime(DataToolsUtils
								.getSimpleDateFormat());
						tbrss.setPoster("panxiaochao");
						tbrss.setSource(source);
						tbrss.setSourceDescription(sourceDescription);
						tbrss.setSourceUrl(sourceUrl);
						tbrss.setEtitle(node.element("title").getText());
						tbrss.setElink(node.element("link").getText());
						tbrss.setEdescription(node.element("description")
								.getText());
						tbrss.setEpubDate(pubdate);
						tbrss.setMacaddr(macaddr);
						listElement.add(tbrss);
					} else {
						if (!node.element("link").getText().equals(link_sub)
								&& flag) {
							System.out.println("属于可录入新闻！");
							TBRss tbrss = new TBRss();
							tbrss.setCreatetime(DataToolsUtils
									.getSimpleDateFormat());
							tbrss.setPoster("panxiaochao");
							tbrss.setSource(source);
							tbrss.setSourceDescription(sourceDescription);
							tbrss.setSourceUrl(sourceUrl);
							tbrss.setEtitle(node.element("title").getText());
							tbrss.setElink(node.element("link").getText());
							tbrss.setEdescription(node.element("description")
									.getText());
							tbrss.setEpubDate(pubdate);
							tbrss.setMacaddr(macaddr);
							listElement.add(tbrss);
						} else {
							flag = false;
							System.out.println("-------------》新闻重复，拒绝录入！");
						}
					}
				}
			}
		}
		saveToLocal(content, path + DataToolsUtils.getTime()
				+ "[BPMIS_Dom].xml");
		System.out.println("总共录入新闻" + listElement.size() + "条！");
		map.put("list", listElement);
		return map;

	}

	private static void saveToLocal(String data, String filePath) {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(new File(
					filePath)));
			output.write(data);
			output.close();
			System.out.println("下载成功！");
		} catch (IOException e) {
			e.printStackTrace();
			new BusinessException(e.getMessage() + "下载失败！");
		}

	}

	/**
	 * 格式化XML文档
	 * 
	 * @param document
	 *            xml文档
	 * @param charset
	 *            字符串的编码
	 * @return 格式化后XML字符串
	 */
	public static String formatXML(Document document, String charset) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding(charset);
		StringWriter sw = new StringWriter();
		XMLWriter xw = new XMLWriter(sw, format);
		try {
			xw.write(document);
			xw.flush();
			xw.close();
		} catch (IOException e) {
			logger.error("格式化XML文档发生异常，请检查！", e);
		}
		return sw.toString();
	}

	/**
	 * @Description: TODO(定时爬取标签内容)
	 */
	@SuppressWarnings("unchecked")
	public void CrawlerRss() {
		List listtag = systemService
				.queryForList("select feedurl from tb_rsstag");
		String logcontent = "";
		for (Object object : listtag) {
			Map map = (Map) object;
			Map<String, Object> maprss = RSSParserUtil.RssHome(map.get(
					"feedurl").toString());
			Map<String, Object> mapdom = DomjXmlIT.parserStringXml(maprss.get(
					"xmlcontent").toString());
			List<TBRss> list = (List<TBRss>) mapdom.get("list");
			if (list.size() != 0)
				systemService.saveAll(list);
			logcontent = "[******" + DataToolsUtils.getSimpleDateFormat()
					+ " 抓取网址  " + map.get("feedurl") + " ，总共更新数据 "
					+ list.size() + "条******]";
			System.out.println(logcontent);
			systemService.addLogger(logcontent, Globals.Logger_Leavel_INFO,
					Globals.Logger_Type_INSERT);
		}
		// System.out.println(DataToolsUtils.getSimpleDateFormat());
	}

	public static void main(String[] args) {
		DomjXmlIT.parserXml(path + "1387870077203[BPMIS].xml");
	}
}
