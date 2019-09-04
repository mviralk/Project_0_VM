package com.mistbank.model;

import java.util.Date;

public class MistUser extends MistLogin {
	
	private String username;
	private String firstname;
	private String lastname;
	private Date dob;
	private long ssn;
	private long phonenumber;
	
	public MistUser() {
		// TODO Auto-generated constructor stub
	}

	

	public MistUser(String username, String password) {
		super(password);
		this.username = username;
	}



	public MistUser( String username,String password, String firstname, String lastname, Date dob,
			long ssn, long phonenumber) {
		super(password);
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.ssn = ssn;
		this.phonenumber = phonenumber;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "MistUser [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", ssn=" + ssn + ", phonenumber=" + phonenumber + "]";
	}
	
	
	
}
