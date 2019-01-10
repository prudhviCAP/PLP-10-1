package com.cg.insurance.bean;

public class CreateAccount {
	
	public static enum role{user, agent, admin;}
	
	private String username;
	private String password;
	private role role_code;
	
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
	public role getRole_code() {
		return role_code;
	}
	public void setRole_code(role role_code) {
		this.role_code = role_code;
	}
	
	

}
