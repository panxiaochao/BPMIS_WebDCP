package org.pxcbpmisframework.core.crawler;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FileDownLoader {

	/**
	 * 根据 url 和网页类型生成需要保存的网页的文件名 去除掉 url 中非文件名字符
	 */
	public String getFileNameByUrl(String url, String contentType) {
		url = url.substring(7);// remove http://
		if (contentType.indexOf("html") != -1)// text/html
		{
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
			return url;
		} else// 如application/pdf
		{
			return url.replaceAll("[\\?/:*|<>\"]", "_") + "."
					+ contentType.substring(contentType.lastIndexOf("/") + 1);
		}
	}

	/**
	 * 保存网页字节数组到本地文件 filePath 为要保存的文件的相对地址
	 */
	private void saveToLocal(byte[] data, String filePath) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(
					new File(filePath)));
			for (int i = 0; i < data.length; i++)
				out.write(data[i]);
			out.flush();
			out.close();
			System.out.println("下载成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 下载 url 指向的网页 */
	public String downloadFile(String url) {
		String filePath = "";

		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httpget
		HttpGet httpget = new HttpGet(url);

		try {
			CloseableHttpResponse response;
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			try {

				if (entity != null) {
					System.err.println("Method failed: "
							+ entity.getContentLength());
					filePath = null;
				}
				byte[] responseBody = EntityUtils.toByteArray(entity);// 读取为字节数组
				filePath = "E:\\index\\"
						+ getFileNameByUrl(url, entity.getContentType()
								.getValue());
				saveToLocal(responseBody, filePath);
			} catch (IOException e) {
				// 发生网络异常
				e.printStackTrace();
			} finally {
				// 释放连接
				response.close();
				httpclient.close();
			}
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return filePath;
	}

	// 测试的 main 方法
	public static void main(String[] args) {
		FileDownLoader downLoader = new FileDownLoader();
		downLoader.downloadFile("http://www.ithome.com");
	}
}
