package com.appjishu.passport.model;

import java.io.Serializable;

/** 
* @author liushaoming(liushaomingdev@163.com)
* @version 创建时间：2017年8月20日 下午2:19:33 
* 类说明 
*/
public class Passport implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId = 0L;
	private String token = "";
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
