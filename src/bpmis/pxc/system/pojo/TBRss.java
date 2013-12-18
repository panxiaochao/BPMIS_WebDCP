package bpmis.pxc.system.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @ClassName: TBRss
 * @Description: TODO(RSS订阅)
 * @author Mr_Pxc
 * @date 2013-12-18 下午03:23:00
 * @project_name：BPMIS_WebDCP
 * @version 1.0
 */
@Entity
@Table(name = "tb_rss")
public class TBRss implements java.io.Serializable{
	private Integer id;
	private String source;
	private String sourceUrl;
	private String sourceDescription;

	private String etitle;
	private String elink;
	private String edescription;
	private String epubDate;

	private String createtime;
	private String poster;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getSourceDescription() {
		return sourceDescription;
	}

	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
	}

	public String getEtitle() {
		return etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	public String getElink() {
		return elink;
	}

	public void setElink(String elink) {
		this.elink = elink;
	}

	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	public String getEpubDate() {
		return epubDate;
	}

	public void setEpubDate(String epubDate) {
		this.epubDate = epubDate;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

}
