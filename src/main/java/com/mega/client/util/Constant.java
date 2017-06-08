package com.mega.client.util;

/**
 * 系统常量类
 * @author Andy.jia
 * @date 2017年5月16日
 * @version V1.0
 */
public class Constant {
	
	/**
	 * 
	 */
	public static final String APPLECTION_PROJECT = "APPLECTION_PROJECT_";
	
	/**
	 * 主信息数据状态
	 * normal=正常
	 * exception = 异常
	 */
	public enum DataState {
		normal,exception
	}
	
	/**
	 * 异常信息数据提醒方式
	 * sys 系统提醒
	 * sms 短信提醒
	 * all 两者都有
	 */
	public enum RemindType{
		sys,sms,all
	}
	
	/**
	 * 异常信息解决方案
	 * tag 标记为解决
	 * lag 延迟解决
	 * complete 已解决
	 * ignore 忽略
	 */
	public enum SolutionType{
		tag,lag,complete,ignore
	}
	
	
	

}
