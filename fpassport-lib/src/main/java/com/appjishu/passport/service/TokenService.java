package com.appjishu.passport.service;

import org.apache.ibatis.annotations.Param;
import com.appjishu.passport.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/** 
* @author liushaoming(liushaomingdev@163.com)
* @version 创建时间：2017年8月27日 上午11:00:37 
* 类说明 
*/
@Service
public class TokenService {
	@Autowired
	private TokenDAO tokenDAO;
	
	@Autowired
	private TokenRedisService tokenRedisService;
	
	public String getToken(Long userId) {
		String cachedToken = tokenRedisService.getToken(userId);
		String token = "";
		if (StringUtils.isEmpty(cachedToken)) {
			token = tokenDAO.getToken(userId);
		} else {
			token = cachedToken;
		}
		return token;
	}
	
	public String copyTokenToCache(Long userId) {
		String tokenInDB = tokenDAO.getToken(userId);
		tokenRedisService.setToken(userId, tokenInDB);
		return tokenInDB;
	}
	
	public Integer insert(Long userId, String token, Long expire) {
		Integer count = tokenDAO.insert(userId, token, expire);
		if (count > 0) {
			tokenRedisService.setToken(userId, token);
		}
		return count;
	}
	
	public Integer updateToken(Long userId, String token) {
		Integer count = tokenDAO.updateToken(userId, token);
		if (count > 0) {
			tokenRedisService.setToken(userId, token);
		}
		return count;
	}
}
