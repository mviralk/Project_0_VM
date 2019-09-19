package com.mistbank.model;

import java.util.Date;

public class CheckingAccounts extends MistUser {
	
	private long checkingaccountnumber;
	private double checkingavailablebalance;
					 
	
	public CheckingAccounts() {
		// TODO Auto-generated constructor stub
	}

	public long getCheckingaccountnumber() {
		return checkingaccountnumber;
	}

	public void setCheckingaccountnumber(long checkingaccountnumber) {
		this.checkingaccountnumber = checkingaccountnumber;
	}

	public double getCheckingavailablebalance() {
		return checkingavailablebalance;
	}

	public void setCheckingavailablebalance(double checkingavailablebalance) {
		this.checkingavailablebalance = checkingavailablebalance;
	}


	public CheckingAccounts(long checkingaccountnumber, double checkingavailablebalance,
			double checkingcurrentbalance) {
		super();
		this.checkingaccountnumber = checkingaccountnumber;
		this.checkingavailablebalance = checkingavailablebalance;
	}
	
	

	public CheckingAccounts(String username, String password, String firstname, String lastname, Date dob, long ssn,
			long phonenumber) {
		super(username, password, firstname, lastname, dob, ssn, phonenumber);
		//this.checkingaccountnumber = checkingaccountnumber;
		//this.checkingavailablebalance = checkingavailablebalance;
	}

	@Override
	public String toString() {
		return "CheckingAccounts [checkingaccountnumber=" + checkingaccountnumber + ", checkingavailablebalance="
				+ checkingavailablebalance + "]";
	}
	
	

}
