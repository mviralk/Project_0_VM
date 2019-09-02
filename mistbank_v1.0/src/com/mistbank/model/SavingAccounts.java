package com.mistbank.model;

import java.util.Date;

public class SavingAccounts extends MistUser {

	private long savingaccountnumber;
	private double savingavailablebalance;
	private float savinginterest;


	public float getSavinginterest() {
		return savinginterest;
	}


	public void setSavinginterest(float savinginterest) {
		this.savinginterest = savinginterest;
	}
	
	


	public SavingAccounts(String username, String password, String firstname, String lastname, Date dob, long ssn,
			long phonenumber, long savingaccountnumber, double savingavailablebalance, float savinginterest) {
		super(username, password, firstname, lastname, dob, ssn, phonenumber);
		this.savingaccountnumber = savingaccountnumber;
		this.savingavailablebalance = savingavailablebalance;
		this.savinginterest = savinginterest;
	}
	
	


	public SavingAccounts(String username, String password, String firstname, String lastname, Date dob, long ssn,
			long phonenumber) {
		super(username, password, firstname, lastname, dob, ssn, phonenumber);
		//this.savingavailablebalance = savingavailablebalance;
		//this.savinginterest = savinginterest;
	}


	public SavingAccounts() {
		// TODO Auto-generated constructor stub
	}


	public long getSavingaccountnumber() {
		return savingaccountnumber;
	}


	public void setSavingaccountnumber(long savingaccountnumber) {
		this.savingaccountnumber = savingaccountnumber;
	}


	public double getSavingavailablebalance() {
		return savingavailablebalance;
	}


	public void setSavingavailablebalance(double savingavailablebalance) {
		this.savingavailablebalance = savingavailablebalance;
	}


	public SavingAccounts(long savingaccountnumber, double savingavailablebalance, float savinginterest) {
		super();
		this.savingaccountnumber = savingaccountnumber;
		this.savingavailablebalance = savingavailablebalance;
		this.savinginterest = savinginterest;
	}


	@Override
	public String toString() {
		return "SavingAccounts [savingaccountnumber=" + savingaccountnumber + ", savingavailablebalance="
				+ savingavailablebalance + ", savinginterest=" + savinginterest + "]";
	}
	
	
	
}