package com.mega.bdf2.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.model.DefaultUser;
import com.bstek.bdf2.core.service.IDeptService;
import com.bstek.bdf2.core.service.IFrameworkService;
import com.bstek.bdf2.core.service.IGroupService;
import com.bstek.bdf2.core.service.IPositionService;
import com.bstek.dorado.console.Logger;
import com.bstek.dorado.core.Configure;
import com.google.code.kaptcha.Constants;

/**
 * 重写登录验证
 * @author Andy
 *
 */
@Component(IFrameworkService.BEAN_ID)
public class FrameworkServiceImpl implements IFrameworkService{
	
	@Autowired
	private IPositionService positionService;
	@Autowired
	private IGroupService groupService;
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private Logger log = Logger.getLog(FrameworkServiceImpl.class);

	@SuppressWarnings("deprecation")
	@Override
	public void authenticate(IUser user, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		log.info("--------------------");
		
		this.preChecks(authentication);
		DefaultUser defaultUser=(DefaultUser)user;
		String presentedPassword = authentication.getCredentials().toString();
        if (!passwordEncoder.isPasswordValid(user.getPassword(), presentedPassword,defaultUser.getSalt())) {
            throw new BadCredentialsException("The password is invalid");
        }else{
        	defaultUser.setDepts(deptService.loadUserDepts(user.getUsername()));
        	defaultUser.setPositions(positionService.loadUserPositions(user.getUsername()));
        	defaultUser.setGroups(groupService.loadUserGroups(user.getUsername()));
        }
	}
	private void preChecks(UsernamePasswordAuthenticationToken authentication)throws AuthenticationException{
		boolean useCaptcha=Configure.getBoolean("bdf2.useCaptchaForLogin");
		if(useCaptcha){
			String key=ContextHolder.getRequest().getParameter("captcha_");
			if(StringUtils.isNotEmpty(key)){
				String sessionkey=(String)ContextHolder.getHttpSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
				if(sessionkey==null){
					throw new BadCredentialsException("验证码过期");
				}else if(!sessionkey.equals(key)){
					throw new BadCredentialsException("验证码不正确");					
				}
			}else{
				throw new BadCredentialsException("验证码不能为空");					
			}
		}
		if (authentication.getPrincipal() == null) {
			throw new BadCredentialsException("Username can not be null");
		}
		if (authentication.getCredentials() == null) {
			throw new BadCredentialsException("password can not be null");
		}
	}

}
