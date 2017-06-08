package com.mega.client.service;

import java.util.List;

import com.mega.client.model.ProjectIedPort;

/**
 * 
 * @author Andy.jia
 *
 */
public interface IProjectIedPortService {
	
	public static final String BEAN_ID = "soft.projectIedPortService";
	
	/**
	 * 新增数据
	 * @param port
	 * @return
	 */
	public String saveProjectIdePort(ProjectIedPort port);

	/**
	 * 根据服务器ID获取服务器节点信息
	 * @param iedId
	 * @return
	 */
	public List<ProjectIedPort> loadDataByIedId(String iedId);

}
