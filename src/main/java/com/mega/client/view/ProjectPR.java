package com.mega.client.view;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.web.DoradoContext;
import com.mega.client.model.ProjectDevice;
import com.mega.client.model.ProjectGroup;
import com.mega.client.model.ProjectIed;
import com.mega.client.model.ProjectIedPort;
import com.mega.client.service.IProjectDeviceService;
import com.mega.client.service.IProjectGroupService;
import com.mega.client.service.IProjectIedPortService;
import com.mega.client.service.IProjectIedService;
import com.mega.client.util.Constant;

/**
 * 
 * @author Andy.jia
 *
 */
@Component(ProjectPR.BEAN_ID)
public class ProjectPR {
	
	public static final String BEAN_ID = "soft.projectPR";
	
	@Autowired
	private IProjectGroupService projectGroupService;
	@Autowired
	private IProjectIedService projectIedService;
	@Autowired
	private IProjectIedPortService projectIedPortService;
	@Autowired
	private IProjectDeviceService projectDeviceService;
	
	/**
	 * soft.projectPR#getProjectGroup
	 * @param companyId
	 * @return
	 */
	@DataProvider
	public List<ProjectGroup> getProjectGroup(String companyId){
		if(StringUtils.isBlank(companyId)) {
			companyId = ContextHolder.getLoginUser().getCompanyId();
		}
		
		//从缓存中获取
		List<ProjectGroup> list = null;//(List<ProjectGroup>) DoradoContext.getCurrent().getAttribute(DoradoContext.APPLICATION, Constant.APPLECTION_PROJECT+companyId);
		//if(null != list) return list;
		
		list = getListProjectGroup(companyId);
		
		//放到缓存中
		DoradoContext.getCurrent().setAttribute(DoradoContext.APPLICATION, Constant.APPLECTION_PROJECT+companyId, list);
		return list;
	}
	
	/**
	 * 通过组织编码获取项目信息
	 * @param companyId
	 * @return
	 */
	private List<ProjectGroup> getListProjectGroup(String companyId) {
		List<ProjectGroup> list = projectGroupService.loadDataByCompanyId(companyId);
		if(null == list) return list;
		
		for (ProjectGroup projectGroup : list) {
			projectGroup.setIeds(getProjectIed(projectGroup.getPkId()));
		}
		return list;
	}
	
	

	/**
	 * 通过项目分组信息获取服务器信息
	 * @param groupId
	 * @return
	 */
	public List<ProjectIed> getProjectIed(String groupId){
		List<ProjectIed> ieds = projectIedService.loadDataByGroupId(groupId);
		if(null == ieds) return ieds;
		for (ProjectIed projectIed : ieds) {
			projectIed.setPorts(getProjectIedPort(projectIed.getPkId()));
		}
		return ieds;
	}
	
	/**
	 * 通过服务器ID获取服务器节点信息
	 * @param iedId
	 * @return
	 */
	public List<ProjectIedPort> getProjectIedPort(String iedId){
		List<ProjectIedPort> ports = projectIedPortService.loadDataByIedId(iedId);
		if(null == ports) return ports;
		for (ProjectIedPort projectIedPort : ports) {
			projectIedPort.setDevices(getProjectDevice(projectIedPort.getPkId()));
		}
		return ports;
	}
	
	/**
	 * 通过节点信息获取节点上的终端设备
	 * @param portId
	 * @return
	 */
	public List<ProjectDevice> getProjectDevice(String portId){
		return projectDeviceService.loadDataByPortId(portId);
	}

}
