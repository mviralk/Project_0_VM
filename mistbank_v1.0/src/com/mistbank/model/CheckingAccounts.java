package com.mistbank.model;

public class CheckingAccounts {
	
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

	@Override
	public String toString() {
		return "CheckingAccounts [checkingaccountnumber=" + checkingaccountnumber + ", checkingavailablebalance="
				+ checkingavailablebalance + "]";
	}
	
	

}