package com.mega.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.mega.client.model.ProjectIed;
import com.mega.client.service.IProjectIedService;

/**
 * 
 * @author Andy.jia
 *
 */
@Repository(IProjectIedService.BEAN_ID)
public class ProjectIedServiceImpl extends HibernateDao implements IProjectIedService {

	@Override
	public String saveProjectIed(ProjectIed ied) {
		if (StringUtils.isBlank(ied.getPkId())) {
			ied.setPkId(UUID.randomUUID().toString());
		}

		Session session = this.getSessionFactory().openSession();
		try {
			session.save(ied);
		} finally {
			session.flush();
			session.close();
		}
		return ied.getPkId();
	}

	@Override
	public List<ProjectIed> loadDataByGroupId(String groupId) {
		if(StringUtils.isBlank(groupId)) return null;
		String hql =" from "+ProjectIed.class.getName()+" where groupId =:groupId ";
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("groupId", groupId);
		return this.query(hql, param);
	}

}
