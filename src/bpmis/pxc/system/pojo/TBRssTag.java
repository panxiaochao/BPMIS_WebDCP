package bpmis.pxc.system.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @ClassName: TBRssTag
 * @Description: TODO(RSSTag标签)
 * @author Mr_Pxc
 * @date 2013-12-18 下午03:23:00
 * @project_name：BPMIS_WebDCP
 * @version 1.0
 */
@Entity
@Table(name = "tb_rsstag")
public class TBRssTag implements java.io.Serializable {
	private Integer id;
	private String tagname;
	private String feedurl;
	private String sysfig;  //0.系统  1.自添
	private String macaddr;
	private String createtime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public String getFeedurl() {
		return feedurl;
	}

	public void setFeedurl(String feedurl) {
		this.feedurl = feedurl;
	}

	public String getSysfig() {
		return sysfig;
	}

	public void setSysfig(String sysfig) {
		this.sysfig = sysfig;
	}

	public String getMacaddr() {
		return macaddr;
	}

	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}
