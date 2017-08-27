package org.flylib.passport.model;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月27日 上午9:58:06 
* 类说明 
*/
public class Token {
	private Long userId;
	private String token;
	private Long expire;
	private String createTime;
	private String updateTime;
	
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
	public Long getExpire() {
		return expire;
	}
	public void setExpire(Long expire) {
		this.expire = expire;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
