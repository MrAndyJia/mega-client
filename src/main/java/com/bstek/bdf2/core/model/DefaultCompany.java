package com.bstek.bdf2.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;

/**
 * 
 * @Desc 重写JAR包中的代码，添加扩展字段
 * @author Andy.jia
 * @date 2017年5月9日
 * @version V1.0
 */
@Entity
@Table(name = "BDF2_COMPANY")
public class DefaultCompany implements java.io.Serializable {
	
	private static final long serialVersionUID = -6326282268106128108L;
	
	@Id
	@Column(name = "ID_", length = 60)
	private String id;
	@Column(name = "NAME_", length = 60)
	private String name;
	@Column(name = "DESC_", length = 120)
	private String desc;
	
	@Column(name = "START_TIME_")
	@PropertyDef(label="授权开始")
	private Date startTime;
	
	@Column(name = "END_TIME_")
	@PropertyDef(label="授权结束")
	private Date EndTime;
	
	@Column(name = "ADDRESS_", length = 500)
	@PropertyDef(label="详细地址")
	private String address;
	
	@Column(name = "CONTACT_USER", length = 100)
	@PropertyDef(label="联系人")
	private String contactUser;
	
	@Column(name = "CONTACT_PHONE", length = 100)
	@PropertyDef(label="联系电话")
	private String contactPhone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactUser() {
		return contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
}
