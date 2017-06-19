package com.mega.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;

/**
 * 设备Socket传递过来的数据
 * @author Andy
 *
 */
@Entity
@Table(name="SOFT_SOCKET_INFO")
public class SocketInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_",unique= true,length=38)
	@PropertyDef(label="信息主键ID")
	private String id;
	
	@Column(name = "COMPANY_ID_",length=10)
	@PropertyDef(label="组织编码")
	private String companyId;
	
	@Column(name = "DEVICE_ID_",length=10)
	@PropertyDef(label="设备编码")
	private String deviceId;
	
	@Column(name = "INFO_",length=200)
	@PropertyDef(label="信息内容")
	private String info;
	
	@Column(name = "EXCEP_TAG_",length=10)
	@PropertyDef(label="异常标记")
	private String excepTag;
	

	public SocketInfo() {
		super();
	}

	public SocketInfo(String id, String companyId, String deviceId, String info, String excepTag) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.deviceId = deviceId;
		this.info = info;
		this.excepTag = excepTag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getExcepTag() {
		return excepTag;
	}

	public void setExcepTag(String excepTag) {
		this.excepTag = excepTag;
	}

	@Override
	public String toString() {
		return "SocketInfo [id=" + id + ", companyId=" + companyId + ", deviceId=" + deviceId + ", info=" + info
				+ ", excepTag=" + excepTag + "]";
	}
}
