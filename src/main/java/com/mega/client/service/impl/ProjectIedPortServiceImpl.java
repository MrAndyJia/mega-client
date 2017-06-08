package com.mega.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.mega.client.model.ProjectIedPort;
import com.mega.client.service.IProjectIedPortService;

/**
 * 
 * @author Andy.jia
 *
 */
@Repository(IProjectIedPortService.BEAN_ID)
public class ProjectIedPortServiceImpl extends HibernateDao implements IProjectIedPortService {

	@Override
	public String saveProjectIdePort(ProjectIedPort port) {
		if (StringUtils.isBlank(port.getPkId())) {
			port.setPkId(UUID.randomUUID().toString());
		}

		Session session = this.getSessionFactory().openSession();
		try {
			session.save(port);
		} finally {
			session.flush();
			session.close();
		}
		return port.getPkId();
	}

	@Override
	public List<ProjectIedPort> loadDataByIedId(String iedId) {
		if(StringUtils.isBlank(iedId)) return null;
		String hql =" from "+ProjectIedPort.class.getName()+" where iedId =:iedId ";
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("iedId", iedId);
		return this.query(hql, param);
	}

}
