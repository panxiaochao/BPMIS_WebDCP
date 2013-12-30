package org.pxcbpmisframework.core.crawler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
public class Crawler {
	/**  
     * 爬虫搜索深度  
     */ 
    public static int depth = 0; 
	private int year;
	private int mouth;
	private int day;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMouth() {
		return mouth;
	}

	public void setMouth(int mouth) {
		this.mouth = mouth;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	public Crawler()
	{
		Calendar calendar = Calendar.getInstance(); 
		year=calendar.get(Calendar.YEAR);
		mouth= calendar.get(Calendar.MONTH)+1;    
		day=calendar.get(Calendar.DATE); 
	}
	/* 爬取方法*/
	public void crawling(String[] seeds)
	{
		LinkFilter filter = new LinkFilter(){
			//提取以 http://www.twt.edu.cn 开头的链接
			public boolean accept(String url) {
				if(url.startsWith("http://news.qq.com/"))
					return true;
				else
					return false;
			}
		};
		//初始化 URL 队列
		//initCrawlerWithSeeds(seeds);
		LinkDb.addUnvisitedUrl(seeds[0]);
		//循环条件：待抓取的链接不空且抓取的网页不多于 1000
		while(!LinkDb.unVisitedUrlsEmpty()&&LinkDb.getVisitedUrlNum()<=10)
		{
			//队头 URL 出对
			String visitUrl=LinkDb.unVisitedUrlDeQueue();
			if(visitUrl==null)
				continue;
			//FileDownLoader downLoader=new FileDownLoader();
			//下载网页
			//downLoader.downloadFile(visitUrl);
			//该 url 放入到已访问的 URL 中
			LinkDb.addVisitedUrl(visitUrl);
			//提取出下载网页中的 URL			
			Set<String> links=HtmlParserTool.extracLinks(visitUrl,filter);
			//新的未访问的 URL 入队
			int i=0;
			
			for(String link:links)
			{
				//if(link.matches("http://tech.sina.com.cn/it/\b("+year+")\b-\b["+mouth+"]{1,2}\b-\b("+day+")\b/\b\\d{11}\b.shtml"))
				//{
					LinkDb.addUnvisitedUrl(link);
					System.out.println(i+"."+link);					
					i++;
				//}				
			}
		}
	}
	
	/**  
     * 以"/"来分割URL,获得超链接的元素  
     *   
     * @param url  
     * @return  
     */ 
    public static String[] divUrl(String url)  
    {  
        return url.split("/");  
    }  
	
	//main 方法入口
	public static void main(String[]args) throws ParserException
	{
		Crawler crawler = new Crawler();
		crawler.crawling(new String[]{"http://news.qq.com/"});
	}
	
}
