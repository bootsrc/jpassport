package org.flylib.passport.model;

import java.io.Serializable;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月20日 下午2:19:33 
* 类说明 
*/
public class Passport implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId = "";
	private String token = "";
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
