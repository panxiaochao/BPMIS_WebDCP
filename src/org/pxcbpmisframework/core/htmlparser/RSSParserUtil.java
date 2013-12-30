package org.pxcbpmisframework.core.htmlparser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.pxcbpmisframework.core.exception.BusinessException;
import org.pxcbpmisframework.core.util.DataToolsUtils;

public class RSSParserUtil {
	private static final Logger logger = Logger.getLogger(RSSParserUtil.class);
	private static String path = "E://index//";
	private static String filename = "";

	public static void main(String[] args) {
		RSSParserUtil
				.RssHome("http://www.pcbeta.com/portal.php?mod=rss&catid=1");
	}

	/*
	 * 返回文件名
	 */
	public static Map<String, Object> RssHome(String feedurl) {
		Map<String, Object> map = new HashMap<String, Object>();
		BufferedReader reader = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(feedurl);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				reader = new BufferedReader(new InputStreamReader(entity
						.getContent(), "utf-8")); // 编码问题
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
					sb.append("\r\n");
				}
				filename = path + DataToolsUtils.getTime() + "[BPMIS_Rss].xml";
				saveToLocal(sb.toString().trim(), filename);
				map.put("xmlcontent", sb.toString().trim());
				map.put("filename", filename);
				//System.out.println(sb.toString());
			}

		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			new BusinessException(e.getMessage());
		} finally {
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}

	private static void saveToLocal(String data, String filePath) {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(new File(
					filePath)));
			output.write(data);
			output.close();
			System.out.println(filename + "下载成功！");
		} catch (IOException e) {
			e.printStackTrace();
			new BusinessException(e.getMessage() + "下载失败！");
		}

	}
}
