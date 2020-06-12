package com.spring.cloud.wlc.base.domain.user;

import java.math.BigInteger;

public class WlcUser {
	private BigInteger userId;
	private String userName;
	private String userPassword;
	private String userToken;
	private String userDesc;
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public WlcUser(BigInteger userId, String userName, String userPassword, String userToken, String userDesc) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userToken = userToken;
		this.userDesc = userDesc;
	}
	public WlcUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
