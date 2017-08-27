package org.flylib.passport.service;

import org.apache.ibatis.annotations.Param;
import org.flylib.passport.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月27日 上午11:00:37 
* 类说明 
*/
@Service
public class TokenService {
	@Autowired
	private TokenDAO tokenDAO;
	
	public String getToken(Long userId) {
		return tokenDAO.getToken(userId);
	}
	
	public Integer insert(Long userId, String token, Long expire) {
		return tokenDAO.insert(userId, token, expire);
	}
}
