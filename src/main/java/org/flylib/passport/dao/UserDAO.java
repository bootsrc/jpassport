package org.flylib.passport.dao;

import org.flylib.passport.model.User;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月26日 下午8:45:39 
* 类说明 
*/
public interface UserDAO {
	String getToken(Long userId);
	Integer insert(User user);
}
