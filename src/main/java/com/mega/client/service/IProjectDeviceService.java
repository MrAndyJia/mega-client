package com.mega.client.service;

import java.util.List;

import com.mega.client.model.ProjectDevice;

/**
 * 
 * @author Andy.jia
 *
 */
public interface IProjectDeviceService {
	
	public static final String BEAN_ID = "soft.projectDeviceService";
	
	/**
	 * 新增数据
	 * @param device
	 * @return
	 */
	public String saveProjectDevice(ProjectDevice device);

	/**
	 * 根据节点ID获取终点设备信息
	 * @param portId
	 * @return
	 */
	public List<ProjectDevice> loadDataByPortId(String portId);

}
