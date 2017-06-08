package com.mega.client.service;

import java.util.List;

import com.mega.client.model.ProjectGroup;

/**
 * 
 * @author Andy.jia
 *
 */
public interface IProjectGroupService {
	
	public static final String BEAN_ID = "soft.projectGroupService";
	
	/**
	 * 数据新增
	 * @param project
	 * @return
	 */
	public String saveProjectGroup(ProjectGroup project);

	/**
	 * 根据编号查看是否已经有生成数据，如果有返回true,没有返回false
	 * @param companyId
	 * @return
	 */
	public boolean isCreatedProject(String companyId);

	/**
	 * 根据组织编码获取项目信息
	 * @param companyId
	 * @return
	 */
	public List<ProjectGroup> loadDataByCompanyId(String companyId);

}
