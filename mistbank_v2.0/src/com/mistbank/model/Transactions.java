package com.mistbank.model;

import java.util.Date;

public class Transactions extends CheckingAccounts{
	
	private long transactionId;
	private double deposit;
	private double withdraw;
	private Date transactionDate;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Transactions(long transactionId, double deposit, double withdraw, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.transactionDate = transactionDate;
	}
	
	

	public Transactions(double deposit) {
		super();
		this.deposit = deposit;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", deposit=" + deposit + ", withdraw=" + withdraw
				+ ", transactionDate=" + transactionDate + "]";
	}
	
	

}
