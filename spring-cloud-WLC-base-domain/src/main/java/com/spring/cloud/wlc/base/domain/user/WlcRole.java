package com.spring.cloud.wlc.base.domain.user;

import java.math.BigInteger;

public class WlcRole {
	private BigInteger roleId;
	private String roleName;
	private Integer roleStatus;
	private Integer roleType;
	private String roleDesc;
	public BigInteger getRoleId() {
		return roleId;
	}
	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public WlcRole(BigInteger roleId, String roleName, Integer roleStatus, Integer roleType, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleStatus = roleStatus;
		this.roleType = roleType;
		this.roleDesc = roleDesc;
	}
	public WlcRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
