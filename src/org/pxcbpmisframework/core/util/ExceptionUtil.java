package org.pxcbpmisframework.core.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Exception������
 * 
 */
public class ExceptionUtil {

	/**
	 * ���ش�����Ϣ�ַ���
	 * 
	 * @param ex
	 *            Exception
	 * @return ������Ϣ�ַ���
	 */
	public static String getExceptionMessage(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		return sw.toString();
	}

}
