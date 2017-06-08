package com.mega.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bstek.dorado.annotation.PropertyDef;

/**
 * 服务器上断点
 * @Desc
 * @author Andy.jia
 * @date 2017年5月24日
 * @version V1.0
 */
@Entity
@Table(name = "SOFT_PROJECT_IDE_PORT")
public class ProjectIedPort {
	
	@Id
	@Column(name ="PK_ID_",length=50)
	@PropertyDef(label="主键ID")
	private String pkId;
	
	@Column(name ="IED_ID_",length=50)
	@PropertyDef(label="服务器ID")
	private String iedId;
	
	@Column(name ="COM_",length=20)
	@PropertyDef(label="")
	private String com;
	
	@Column(name ="NAME_",length=100)
	@PropertyDef(label="")
	private String name;
	
	@Column(name ="MODE_",length=50)
	@PropertyDef(label="")
	private String mode;
	
	@Column(name ="BAUDRATE_",length=50)
	@PropertyDef(label="")
	private String baudrate;
	
	@Column(name ="DATABITS_",length=50)
	@PropertyDef(label="")
	private String databits;
	
	@Column(name ="STOPBITS_",length=50)
	@PropertyDef(label="")
	private String stopbits;
	
	@Column(name ="PARITY_",length=50)
	@PropertyDef(label="")
	private String parity;
	
	@Column(name ="FLOW_CONTROL_",length=50)
	@PropertyDef(label="")
	private String flowcontrol;
	
	@Column(name ="DELAY_",length=50)
	@PropertyDef(label="")
	private String delay;
	
	@Column(name ="VALID_",length=1)
	@PropertyDef(label="")
	private String valid;
	
	@Transient
	private List<ProjectDevice> devices;

	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	public String getIedId() {
		return iedId;
	}

	public void setIedId(String iedId) {
		this.iedId = iedId;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getBaudrate() {
		return baudrate;
	}

	public void setBaudrate(String baudrate) {
		this.baudrate = baudrate;
	}

	public String getDatabits() {
		return databits;
	}

	public void setDatabits(String databits) {
		this.databits = databits;
	}

	public String getStopbits() {
		return stopbits;
	}

	public void setStopbits(String stopbits) {
		this.stopbits = stopbits;
	}

	public String getParity() {
		return parity;
	}

	public void setParity(String parity) {
		this.parity = parity;
	}

	public String getFlowcontrol() {
		return flowcontrol;
	}

	public void setFlowcontrol(String flowcontrol) {
		this.flowcontrol = flowcontrol;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public List<ProjectDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<ProjectDevice> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "ProjectIdePort [pkId=" + pkId + ", iedId=" + iedId + ", com=" + com + ", name=" + name + ", mode="
				+ mode + ", baudrate=" + baudrate + ", databits=" + databits + ", stopbits=" + stopbits + ", parity="
				+ parity + ", flowcontrol=" + flowcontrol + ", delay=" + delay + ", valid=" + valid + "]";
	}
}
