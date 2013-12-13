package bpmis.pxc.system.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @ClassName: TBEmailNotice
 * @Description: TODO(订阅邮件)
 * @author Mr_Pxc
 * @date 2013-12-13 上午10:23:53
 * @project_name：BPMIS_WebDCP
 * @version 1.0
 */
@Entity
@Table(name = "tb_emailnotice")
public class TBEmailNotice implements java.io.Serializable {
	private Integer eid;
	private String email;
	private String ip;
	private String datetime;
	private String projectname;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

}
