package com.mega.client.manager.service;

import java.util.Map;

import com.bstek.bdf2.core.model.DefaultCompany;
import com.bstek.dorado.data.provider.Page;

/**
 * 
 * @author Andy.jia
 *
 */
public interface ICompanyService {
	
	public static final String BEAN_ID = "manager.companyService";
	
	/**
	 * 分页获取组织信息
	 * @param page
	 * @param parameter
	 */
	public void getAll(Page<DefaultCompany> page,Map<String,Object> parameter)throws Exception;


	/**
	 * 根据组织编码生成项目基本信息
	 * @param companyId
	 */
	public void createProject(String companyId)throws Exception;

}
