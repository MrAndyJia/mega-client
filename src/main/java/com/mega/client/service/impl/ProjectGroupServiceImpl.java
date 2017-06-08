package com.mega.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.mega.client.model.ProjectGroup;
import com.mega.client.service.IProjectGroupService;

/**
 * 
 * @author Andy.jia
 *
 */
@Repository(IProjectGroupService.BEAN_ID)
public class ProjectGroupServiceImpl extends HibernateDao implements IProjectGroupService {

	@Override
	public String saveProjectGroup(ProjectGroup project) {

		if (StringUtils.isBlank(project.getPkId())) {
			project.setPkId(UUID.randomUUID().toString());
		}

		Session session = this.getSessionFactory().openSession();
		try {
			session.save(project);
		} finally {
			session.flush();
			session.close();
		}
		return project.getPkId();
	}

	@Override
	public boolean isCreatedProject(String companyId) {
		String hql  = "select count(*) from "+ProjectGroup.class.getName() +" where companyId =:companyId";
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("companyId", companyId);
		int result = this.queryForInt(hql, param);
		if(result == 0) return false;
		return true;
	}

	@Override
	public List<ProjectGroup> loadDataByCompanyId(String companyId) {
		if(StringUtils.isBlank(companyId)) return null;
		String hql =" from "+ProjectGroup.class.getName()+" where companyId =:companyId ";
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("companyId", companyId);
		return this.query(hql, param);
	}

}
