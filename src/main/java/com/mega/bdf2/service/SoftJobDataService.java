package com.mega.bdf2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bstek.bdf2.job.model.JobDefinition;
import com.bstek.bdf2.job.service.IJobDataService;
import com.bstek.dorado.core.Configure;

/**
 * 
 * @Desc 系统使用BDF2的JOB需要实现的接口
 * @author Andy.jia
 * @date 2017年5月7日
 * @version V1.0
 */
@Service
public class SoftJobDataService implements IJobDataService {

	@Override
	public List<JobDefinition> filterJobs(List<JobDefinition> jobs) {
		return jobs;
	}

	@Override
	public String getCompanyId() {
		return Configure.getString("default.companyId");
	}

}
