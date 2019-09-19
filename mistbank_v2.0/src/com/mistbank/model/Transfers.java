package com.mistbank.model;

import java.util.Date;

public class Transfers {
	
	private long transferid;
	private long fromaccount;
	private long toaccount;
	private Date transferdate;
	
	public Transfers() {
		// TODO Auto-generated constructor stub
	}

	public Transfers(long transferid, long fromaccount, long toaccount, Date transferdate) {
		super();
		this.transferid = transferid;
		this.fromaccount = fromaccount;
		this.toaccount = toaccount;
		this.transferdate = transferdate;
	}

	public long getTransferid() {
		return transferid;
	}

	public void setTransferid(long transferid) {
		this.transferid = transferid;
	}

	public long getFromaccount() {
		return fromaccount;
	}

	public void setFromaccount(long fromaccount) {
		this.fromaccount = fromaccount;
	}

	public long getToaccount() {
		return toaccount;
	}

	public void setToaccount(long toaccount) {
		this.toaccount = toaccount;
	}

	public Date getTransferdate() {
		return transferdate;
	}

	public void setTransferdate(Date transferdate) {
		this.transferdate = transferdate;
	}

	@Override
	public String toString() {
		return "Transfers [transferid=" + transferid + ", fromaccount=" + fromaccount + ", toaccount=" + toaccount
				+ ", transferdate=" + transferdate + "]";
	}
	
	

}
