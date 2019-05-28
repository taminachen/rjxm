package com.Bean;

public class UserBean {

	private String username;//用户名
	private String password;//密码
	private String platformName;//平台名称
	private String platformId;//平台ID
	private String approvalTime;//批准时间
	private String approvalNumber;//批准文号
	private String technicalField;//技术领域
	private int status;//用户身份
	
	//封装函数
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getApprovalTime() {
		return approvalTime;
	}
	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}
	public String getApprovalNumber() {
		return approvalNumber;
	}
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	public String getTechnicalField() {
		return technicalField;
	}
	public void setTechnicalField(String technicalField) {
		this.technicalField = technicalField;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
