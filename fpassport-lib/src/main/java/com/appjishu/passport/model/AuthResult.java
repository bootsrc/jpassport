package com.appjishu.passport.model;

import java.io.Serializable;

/**
* @author liushaoming(liushaomingdev@163.com)
* @version 创建时间：2017年8月27日 上午11:15:52 
* 类说明 
*/
public class AuthResult implements Serializable {
	private static final long serialVersionUID = 3338533726508799286L;
	private long userId;
	private String token;
	private String username;
	private String code;
	private String codeDesc;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
}
