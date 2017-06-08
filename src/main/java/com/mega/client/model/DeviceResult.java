package com.mega.client.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;
import com.mega.client.util.Constant;

/**
 * 
 * @Desc
 * @author Andy.jia
 * @date 2017年5月16日
 * @version V1.0
 */
@Table(name = "SOFT_DEVICE_RESULT")
@Entity
public class DeviceResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_", length = 38, unique = true)
	@PropertyDef(label = "主键")
	private String uuid;

	@Column(name = "COMPANY_ID_", length = 20, nullable = false)
	@PropertyDef(label = "组织编码")
	private String companyId;

	@Column(name = "PROJECT_ID_", length = 20, nullable = false)
	@PropertyDef(label = "设备编码")
	private String projectId;

	@Column(name = "VALUE_", length = 1000, nullable = false)
	@PropertyDef(label = "设备信息")
	private String value;

	@Column(name = "DATE_STATE_", length = 10)
	@PropertyDef(label = "数据状态")
	private String dataState = Constant.DataState.normal.toString();

	@Column(name = "CREATE_TIME_")
	@PropertyDef(label = "创建时间")
	private Date createTime;
	
	@Column(name = "REMARK_",length = 200)
	@PropertyDef(label = "备注说明")
	private String remark;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDataState() {
		return dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
