package com.mistbank.model;

public class MistLogin {
	
	private long serialnum;
	private String userpassword;
	
	
	
	public MistLogin(String userpassword) {
		super();
		this.userpassword = userpassword;
	}

	public MistLogin() {
		// TODO Auto-generated constructor stub
	}

	public long getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(long serialnum) {
		this.serialnum = serialnum;
	}

	public String getPassword() {
		return userpassword;
	}

	public void setPassword(String password) {
		this.userpassword = password;
	}

	public MistLogin(long serialnum, String password) {
		super();
		this.serialnum = serialnum;
		this.userpassword = password;
	}

	@Override
	public String toString() {
		return "MistLogin [serialnum=" + serialnum + ", password=" + userpassword + "]";
	}
	
	

}
