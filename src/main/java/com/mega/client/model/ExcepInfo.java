package com.mega.client.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;
/**
 * 数据异常信息
 * @Desc 
 * @author Andy.jia
 * @date 2017年5月16日
 * @version V1.0
 */
@Entity
@Table(name = "SOFT_EXCEP_INFO")
public class ExcepInfo  implements Serializable{

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
	
	@Column(name = "MAIN_DATA_ID_", length = 38, unique = true)
	@PropertyDef(label = "主数据ID")
	private String mainDataId;
	
	@Column(name = "CREATE_TIME_")
	@PropertyDef(label = "异常时间")
	private Date createTime;
	
	@Column(name = "REMIND_TYPE_",length = 10)
	@PropertyDef(label = "提醒方式")
	private String remindType;
	
	@Column(name = "REASON_",length = 100)
	@PropertyDef(label = "异常原因")
	private String reason;
	
	@Column(name = "SOLUTION_TYPE_",length = 20)
	@PropertyDef(label = "解决方式")
	private String solutionType;
	
	@Column(name = "SOLUTION_USER_",length = 20)
	@PropertyDef(label = "解决问题人")
	private String solutionUser;
	
	@Column(name = "SOLUTION_CUSER_",length = 50)
	@PropertyDef(label = "解决问题人名")
	private String solutionCUser;
	
	@Column(name = "SOLUTION_TIME_")
	@PropertyDef(label = "解决问题时间")
	private Date solutionTime;
	
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

	public String getMainDataId() {
		return mainDataId;
	}

	public void setMainDataId(String mainDataId) {
		this.mainDataId = mainDataId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemindType() {
		return remindType;
	}

	public void setRemindType(String remindType) {
		this.remindType = remindType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSolutionType() {
		return solutionType;
	}

	public void setSolutionType(String solutionType) {
		this.solutionType = solutionType;
	}

	public String getSolutionUser() {
		return solutionUser;
	}

	public void setSolutionUser(String solutionUser) {
		this.solutionUser = solutionUser;
	}

	public String getSolutionCUser() {
		return solutionCUser;
	}

	public void setSolutionCUser(String solutionCUser) {
		this.solutionCUser = solutionCUser;
	}

	public Date getSolutionTime() {
		return solutionTime;
	}

	public void setSolutionTime(Date solutionTime) {
		this.solutionTime = solutionTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
