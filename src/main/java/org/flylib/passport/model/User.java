package org.flylib.passport.model;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月26日 下午8:59:11 
* 类说明 
*/
public class User {
	private Long id;
	private String uionid;
	private String crateTime;
	private String upateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUionid() {
		return uionid;
	}
	public void setUionid(String uionid) {
		this.uionid = uionid;
	}
	public String getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(String crateTime) {
		this.crateTime = crateTime;
	}
	public String getUpateTime() {
		return upateTime;
	}
	public void setUpateTime(String upateTime) {
		this.upateTime = upateTime;
	}
	
}
