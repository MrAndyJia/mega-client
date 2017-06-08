package com.mega.client.service;

import java.util.List;

import com.mega.client.model.ProjectIed;

/**
 * 
 * @author Andy.jia
 *
 */
public interface IProjectIedService {
	
	public static final String BEAN_ID = "soft.projectIedService";
	
	/**
	 * 新增数据
	 * @param ied
	 * @return
	 */
	public String saveProjectIed(ProjectIed ied);

	/**
	 * 根据项目分组编码获取服务器信息
	 * @param groupId
	 * @return
	 */
	public List<ProjectIed> loadDataByGroupId(String groupId);

}
