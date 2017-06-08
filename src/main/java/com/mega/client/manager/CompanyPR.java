package com.mega.client.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.model.DefaultCompany;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.mega.client.manager.service.ICompanyService;
import com.mega.client.service.IProjectGroupService;

/**
 * 组织信息维护
 * @author Andy.jia
 *
 */
@Component(CompanyPR.BEAN_ID)
public class CompanyPR {
	
	public static final String BEAN_ID ="manager.companyPR";
	
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private IProjectGroupService projectGroupService;
	
	
	/**
	 * manager.companyPR#getAll
	 * 分页获取组织信息
	 * @param page
	 * @param parameter
	 * @throws Exception 
	 */
	@DataProvider
	public void getAll(Page<DefaultCompany> page,Map<String,Object> parameter) throws Exception{
		companyService.getAll(page, parameter);
	}
	
	/**
	 * manager.companyPR#createProject
	 * @param companyId
	 * @return
	 * @throws Exception 
	 */
	@Expose
	@Transactional(rollbackFor = Exception.class)
	public String createProject(String companyId) throws Exception{
		//判断是否已经有生成
		boolean isCreatedProject = projectGroupService.isCreatedProject(companyId);
		
		if(isCreatedProject) return "该组织下已经生成项目，不支持重复生成。";
		
		companyService.createProject(companyId);
		
		return null;
	}
	
	

}
