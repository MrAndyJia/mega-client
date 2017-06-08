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
@Table(name = "SOFT_PROJECT_GROUP")
public class ProjectGroup {
	
	@Id
	@Column(name ="PK_ID_",length=50)
	@PropertyDef(label="主键ID")
	private String pkId;
	
	@Column(name ="COMPANY_ID_",length=20)
	@PropertyDef(label="公司编码")
	private String companyId;
	
	@Column(name ="GROUP_ID_",length=20)
	@PropertyDef(label="项目名称")
	private String groupId;
	
	@Column(name ="PROJECT_NAME_",length=100)
	@PropertyDef(label="项目名称")
	private String projectName;
	
	@Column(name ="GROUP_NAME_",length=100)
	@PropertyDef(label="项目名称")
	private String groupName;
	
	@Column(name ="IED_URL_",length=100)
	@PropertyDef(label="服务器路径")
	private String iedUrl;
	
	@Transient
	private List<ProjectIed> ieds;
	

	public ProjectGroup() {
		super();
	}

	public ProjectGroup(String projectName, String groupName, String groupId, String iedUrl, String companyId) {
		super();
		this.projectName = projectName;
		this.groupName = groupName;
		this.groupId = groupId;
		this.iedUrl = iedUrl;
		this.companyId = companyId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getIedUrl() {
		return iedUrl;
	}

	public void setIedUrl(String iedUrl) {
		this.iedUrl = iedUrl;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	public List<ProjectIed> getIeds() {
		return ieds;
	}

	public void setIeds(List<ProjectIed> ieds) {
		this.ieds = ieds;
	}

	@Override
	public String toString() {
		return "ProjectGroup [pkId=" + pkId + ", companyId=" + companyId + ", groupId=" + groupId + ", projectName="
				+ projectName + ", groupName=" + groupName + ", iedUrl=" + iedUrl + "]";
	}
}
