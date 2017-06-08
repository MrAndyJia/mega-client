package com.mega.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.mega.client.model.ProjectDevice;
import com.mega.client.service.IProjectDeviceService;

/**
 * 
 * @author Andy.jia
 *
 */
@Repository(IProjectDeviceService.BEAN_ID)
public class IProjectDeviceServiceImpl extends HibernateDao implements IProjectDeviceService {

	@Override
	public String saveProjectDevice(ProjectDevice device) {
		if (StringUtils.isBlank(device.getPkId())) {
			device.setPkId(UUID.randomUUID().toString());
		}

		Session session = this.getSessionFactory().openSession();
		try {
			session.save(device);
		} finally {
			session.flush();
			session.close();
		}
		return device.getPkId();
	}

	@Override
	public List<ProjectDevice> loadDataByPortId(String portId) {
		if(StringUtils.isBlank(portId)) return null;
		String hql =" from "+ProjectDevice.class.getName()+" where portId =:portId order by address ";
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("portId", portId);
		return this.query(hql, param);
	}

}
