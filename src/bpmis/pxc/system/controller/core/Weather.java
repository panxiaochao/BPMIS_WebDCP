package bpmis.pxc.system.controller.core;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

public class Weather {
	// main 方法入口
	public static void main(String[] args) {
		Weather crawler = new Weather();
		crawler.wheather();
	}

	// 抓天气
	public void wheather() {
		try {
			String content = "";
			Parser parser = new Parser(
					"http://www.weather.com.cn/weather/101210401.shtml?");// 由中国天气提供
			NodeFilter nodeF = new NodeClassFilter(TableTag.class);
			NodeList nodeList = parser.parse(nodeF);
			for (int i = 0; i <= 2; i++) {
				if (nodeList.elementAt(i) instanceof TableTag) {
					TableTag tag = (TableTag) nodeList.elementAt(i);
					TableRow[] rows = tag.getRows();
					for (int j = 0; j < rows.length; j++) {
						TableRow tr = (TableRow) rows[j];
						TableColumn[] td = tr.getColumns();
						for (int k = 0; k < td.length; k++) {
							content += td[k].toHtml();
						}

					}

				}
			}
			Parser con = new Parser(content);// 由中国天气提供
			TagNameFilter filter = new TagNameFilter("a");
			NodeList nodes = con.parse(filter);
			if (nodes.size() != 0) {
				LinkTag node = (LinkTag) nodes.elementAt(0);
				String today = node.getLinkText();
				LinkTag node1 = (LinkTag) nodes.elementAt(2);
				String tianqi = node1.toPlainTextString();
				LinkTag node2 = (LinkTag) nodes.elementAt(3);
				String high = node2.toPlainTextString();
				LinkTag node3 = (LinkTag) nodes.elementAt(8);
				String low = node3.toPlainTextString();
				System.out.println(today + " ," + tianqi + " " + low.trim()
						+ "~" + high.trim());

				LinkTag node01 = (LinkTag) nodes.elementAt(11);
				String today1 = node01.getLinkText();
				LinkTag node11 = (LinkTag) nodes.elementAt(13);
				String tianqi1 = node11.toPlainTextString();
				LinkTag node21 = (LinkTag) nodes.elementAt(14);
				String high1 = node21.toPlainTextString();
				LinkTag node31 = (LinkTag) nodes.elementAt(19);
				String low1 = node31.toPlainTextString();
				System.out.println(today1 + " ," + tianqi1 + " " + low1.trim()
						+ "~" + high1.trim());

			}
			Parser img = new Parser(content);// 由中国天气提供
			TagNameFilter img1 = new TagNameFilter("img");
			NodeList imgnodes = img.parse(img1);
			if (imgnodes.size() != 0) {
				ImageTag imgtag = (ImageTag) imgnodes.elementAt(0);
				String src = imgtag.getImageURL();
				System.out.println("src=http://www.weather.com.cn" + src);
				ImageTag imgtag1 = (ImageTag) imgnodes.elementAt(2);
				String src1 = imgtag1.getImageURL();
				System.out.println("src=http://www.weather.com.cn" + src1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
