package com.appjishu.passport.service;

import com.appjishu.passport.model.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 
* @author liushaoming(liushaomingdev@163.com)
* @version 创建时间：2017年8月20日 下午2:01:52 
* 类说明 
*/
@Component
public class LoginIntercepterService {
	@Autowired
	private TokenService tokenService;
	
	public Passport getPassport(Long userId) {
		String token = tokenService.getToken(new Long(userId));
		Passport passport = new Passport();
		passport.setUserId(userId);
		passport.setToken(token);
		return passport;
	}
}
