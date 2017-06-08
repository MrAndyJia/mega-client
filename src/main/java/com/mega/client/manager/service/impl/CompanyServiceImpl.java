package com.mega.client.manager.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.model.DefaultCompany;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.provider.Page;
import com.mega.client.manager.service.ICompanyService;
import com.mega.client.xml.ParseProject;
import com.mega.client.xml.ParseProjectDevice;

/**
 * 
 * @author Andy.jia
 *
 */
@Repository(ICompanyService.BEAN_ID)
public class CompanyServiceImpl extends HibernateDao implements ICompanyService {
	
	@Autowired
	private ParseProject parseProject;
	@Autowired
	private ParseProjectDevice parseProjectDevice;

	@Override
	public void getAll(Page<DefaultCompany> page, Map<String, Object> parameter) throws Exception {
		StringBuffer hql = new StringBuffer(" from "+DefaultCompany.class.getName()+" where 1=1 ");
		
		buildSql(hql,parameter);
		
		String countHql = "select count(*) "+ hql.toString();
		hql.append(" order by startTime");
		this.pagingQuery(page, hql.toString(), countHql, parameter);
	}

	
	
	private void buildSql(StringBuffer hql, Map<String, Object> parameter) {
		
	}

	@Override
	public void createProject(String companyId) throws Exception {
		String groupId = parseProject.parse(companyId);
		parseProjectDevice.parse(groupId);
	}

}
