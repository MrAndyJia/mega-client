package com.mega.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.bstek.dorado.annotation.PropertyDef;

@Entity
@Table(name = "SOFT_PROJECT_DEVICE")
public class ProjectDevice {
	
	@Id
	@Column(name ="PK_ID_",length=50)
	@PropertyDef(label="主键ID")
	private String pkId;
	
	@Column(name ="PORT_ID_",length=50)
	@PropertyDef(label="外键ID")
	private String portId;
	
	@Column(name ="NAME_",length=100)
	@PropertyDef(label="设备名称")
	private String name;
	
	@Column(name ="ADDRESS_",length=20)
	@PropertyDef(label="地址")
	private String address;
	
	@Column(name ="LIB_NAME_",length=50)
	@PropertyDef(label="")
	private String libname;
	
	@Column(name ="CFG_NAME_",length=50)
	@PropertyDef(label="")
	private String cfgname;
	
	@Column(name ="VALID_",length=1)
	@PropertyDef(label="")
	private String valid;
	
	@Transient
	@PropertyDef(label="设备名称",description="虚拟字段，用作设备名称显示")
	private String title;
	

	public ProjectDevice() {
		super();
	}

	public ProjectDevice(String pkId, String portId, String name, String address, String libname, String cfgname,
			String valid) {
		super();
		this.pkId = pkId;
		this.portId = portId;
		this.name = name;
		this.address = address;
		this.libname = libname;
		this.cfgname = cfgname;
		this.valid = valid;
	}

	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	public String getPortId() {
		return portId;
	}

	public void setPortId(String portId) {
		this.portId = portId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLibname() {
		return libname;
	}

	public void setLibname(String libname) {
		this.libname = libname;
	}

	public String getCfgname() {
		return cfgname;
	}

	public void setCfgname(String cfgname) {
		this.cfgname = cfgname;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getTitle() {
		if(StringUtils.isNotBlank(name) && name.length()>6 ){
			title =  name.substring(0, 6)+"...";
		}else{
			title = name ;
		}
		return title;
	}

	@Override
	public String toString() {
		return "ProjectDevice [pkId=" + pkId + ", portId=" + portId + ", name=" + name + ", address=" + address
				+ ", libname=" + libname + ", cfgname=" + cfgname + ", valid=" + valid + "]";
	}
	
}
