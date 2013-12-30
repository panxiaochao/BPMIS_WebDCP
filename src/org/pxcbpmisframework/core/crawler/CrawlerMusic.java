package org.pxcbpmisframework.core.crawler;

import java.util.Set;

import org.htmlparser.util.ParserException;



public class CrawlerMusic {

	//main 方法入口
	public static void main(String[]args) throws ParserException
	{
		Crawler crawler = new Crawler();
		String url="http://tech.sina.com.cn/it/";
		String url1="http://www.ithome.com/ityejie/";
		String url2="http://news.qq.com/";
		String url3="http://www.oschina.net/news/list";
		String url4="http://www.iteye.com/";
		String url5="http://news.hiapk.com/";

	}
	//starandroid
	public void starandroid(String url) throws ParserException
	{		
		int i=0;
		LinkDb.addUnvisitedUrl(url);		
		String visitUrl=LinkDb.unVisitedUrlDeQueue();//队头 URL 出对	
		LinkDb.addVisitedUrl(visitUrl);			
		Set<String> links = HtmlParserTool.extracLinks(url,new LinkFilter()//提取出下载网页中的 URL			
		{		
			public boolean accept(String url) {//提取以 http://news.qq.com 开头的链接
				if(url.startsWith("http://news.hiapk.com/"))
					return true;
				else
					return false;
			}			
		});			
		for(String link:links)
		{												
				LinkDb.addUnvisitedUrl(link);
				System.out.println(i+"."+link);	
				i++;					
		}			
	}	
}
