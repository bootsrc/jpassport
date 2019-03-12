package com.appjishu.passport.service;

import com.appjishu.passport.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @author liushaoming(liushaomingdev@163.com)
* @version 创建时间：2017年8月27日 下午9:04:17 
* 类说明 
*/
@Service
public class TokenDBService {
	@Autowired
	private TokenDAO tokenDAO;
	
	public String getToken(Long userId) {
		String token = tokenDAO.getToken(userId);
		return token;
	}
	
	public Integer insert(Long userId, String token, Long expire) {
		Integer count = tokenDAO.insert(userId, token, expire);
		return count;
	}
	
	public Integer updateToken(Long userId, String token) {
		Integer count = tokenDAO.updateToken(userId, token);
		return count;
	}
}
