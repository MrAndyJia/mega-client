package com.mega.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bstek.dorado.annotation.PropertyDef;

/**
 * 
 * @Desc
 * @author Andy.jia
 * @date 2017年5月24日
 * @version V1.0
 */
@Entity
@Table(name = "SOFT_PROJECT_IED")
public class ProjectIed {
	
	@Id
	@Column(name ="PK_ID_",length=50)
	@PropertyDef(label="主键ID")
	private String pkId;
	
	@Column(name ="GROUP_ID_",length=50)
	@PropertyDef(label="外键ID")
	private String groupId;
	
	@Column(name ="ID_",length=20)
	@PropertyDef(label="ID")
	private String id;

	@Column(name ="NAME_",length=100)
	@PropertyDef(label="服务器名")
	private String name;

	@Column(name ="IP_",length=20)
	@PropertyDef(label="IP地址")
	private String ip;

	@Column(name ="TIMESTAMP_",length=30)
	@PropertyDef(label="")
	private String timestamp;

	@Column(name ="DESCRIPTION_",length=100)
	@PropertyDef(label="")
	private String description;

	@Column(name ="ADDRESS_",length=100)
	@PropertyDef(label="")
	private String address;

	@Column(name ="PERSONNEL_",length=100)
	@PropertyDef(label="")
	private String personnel;

	@Column(name ="TELPHONE_",length=20)
	@PropertyDef(label="")
	private String telphone;

	@Column(name ="VALID_",length=1)
	@PropertyDef(label="")
	private String valid;

	@Column(name ="WATCHDOGINTERVAL_",length=50)
	@PropertyDef(label="")
	private String watchdoginterval;

	@Column(name ="MANUFACTURE_",length=50)
	@PropertyDef(label="")
	private String manufacture;

	@Column(name ="GUARANTEE_",length=50)
	@PropertyDef(label="")
	private String guarantee;

	@Column(name ="SERIES_",length=20)
	@PropertyDef(label="")
	private String series;
	
	@Column(name ="MODEL_",length=20)
	@PropertyDef(label="")
	private String model;
	
	@Column(name ="PARAMETRIC_",length=20)
	@PropertyDef(label="")
	private String parametric;
	
	@Column(name ="REMARK_",length=20)
	@PropertyDef(label="")
	private String remark;
	
	@Column(name ="FACTORY_",length=20)
	@PropertyDef(label="")
	private String factory;
	
	@Column(name ="FACTORYTEL_",length=20)
	@PropertyDef(label="")
	private String factorytel;
	
	@Column(name ="FACTORY_ADDRESS_",length=20)
	@PropertyDef(label="")
	private String factoryaddress;
	
	@Column(name ="PRODUCT_IMAGE_NAME_",length=20)
	@PropertyDef(label="")
	private String productimagename;
	
	@Column(name ="STRUCTURE_IMAGE_NAME_",length=20)
	@PropertyDef(label="")
	private String structureimagename;
	
	@Transient
	private List<ProjectIedPort> ports;

	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getWatchdoginterval() {
		return watchdoginterval;
	}

	public void setWatchdoginterval(String watchdoginterval) {
		this.watchdoginterval = watchdoginterval;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getParametric() {
		return parametric;
	}

	public void setParametric(String parametric) {
		this.parametric = parametric;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getFactorytel() {
		return factorytel;
	}

	public void setFactorytel(String factorytel) {
		this.factorytel = factorytel;
	}

	public String getFactoryaddress() {
		return factoryaddress;
	}

	public void setFactoryaddress(String factoryaddress) {
		this.factoryaddress = factoryaddress;
	}

	public String getProductimagename() {
		return productimagename;
	}

	public void setProductimagename(String productimagename) {
		this.productimagename = productimagename;
	}

	public String getStructureimagename() {
		return structureimagename;
	}

	public void setStructureimagename(String structureimagename) {
		this.structureimagename = structureimagename;
	}

	public List<ProjectIedPort> getPorts() {
		return ports;
	}

	public void setPorts(List<ProjectIedPort> ports) {
		this.ports = ports;
	}

	@Override
	public String toString() {
		return "ProjectIed [pkId=" + pkId + ", groupId=" + groupId + ", id=" + id + ", name=" + name + ", ip=" + ip
				+ ", timestamp=" + timestamp + ", description=" + description + ", address=" + address + ", personnel="
				+ personnel + ", telphone=" + telphone + ", valid=" + valid + ", watchdoginterval=" + watchdoginterval
				+ ", manufacture=" + manufacture + ", guarantee=" + guarantee + ", series=" + series + ", model="
				+ model + ", parametric=" + parametric + ", remark=" + remark + ", factory=" + factory + ", factorytel="
				+ factorytel + ", factoryaddress=" + factoryaddress + ", productimagename=" + productimagename
				+ ", structureimagename=" + structureimagename + "]";
	}
}
