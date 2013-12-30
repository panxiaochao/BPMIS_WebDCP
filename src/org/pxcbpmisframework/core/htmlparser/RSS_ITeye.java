package org.pxcbpmisframework.core.htmlparser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

public class RSS_ITeye {
	private static final Logger logger = Logger.getLogger(RSS_ITeye.class);
	private static String url = "http://www.iteye.com/rss";
	public static String head = "ITeye";
	private static String path = "E://index//";

	public static void main(String[] args) {
		RSS_ITeye.RssITeye();
	}

	public static void RssITeye() {
		BufferedReader reader = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				reader = new BufferedReader(new InputStreamReader(entity
						.getContent(), "UTF-8"));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
					sb.append("\r\n");
				}
				// saveToLocal(sb.toString().trim(), path
				// + DataToolsUtils.SimpleFormatTime("yyyy-MM-dd") + "<"
				// + head + ">.xml");
				System.out.println(sb.toString());
			}

		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void saveToLocal(String data, String filePath) {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(new File(
					filePath)));
			output.write(data);
			output.close();
			System.out.println("下载成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
