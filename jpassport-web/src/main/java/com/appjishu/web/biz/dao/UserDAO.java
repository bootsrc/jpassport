package com.appjishu.web.biz.dao;

import com.appjishu.web.model.User;
import org.apache.ibatis.annotations.Param;

/** 
* @author liushaoming(liushaomingdev@163.com)
* @version 创建时间：2017年8月26日 下午8:45:39 
* 类说明 
*/
public interface UserDAO {
	Integer insert(User user);
	User getUserByMobile(@Param("mobile") String mobile);
	User getUserByEmail(@Param("email") String email);
	Integer exist(@Param("field") String field, @Param("fieldValue") String fieldValue);
}
