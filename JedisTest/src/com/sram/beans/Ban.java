package com.sram.beans;

public class Ban {
	private int bid;
	private String bname;
	
	private Xi xi;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Xi getXi() {
		return xi;
	}

	public void setXi(Xi xi) {
		this.xi = xi;
	}

	public Ban() {
		// TODO Auto-generated constructor stub
	}

	public Ban(int bid, String bname, Xi xi) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.xi = xi;
	}

	
	
	
	public Ban(int bid, String bname) {
		super();
		this.bid = bid;
		this.bname = bname;
	}

	@Override
	public String toString() {
		return "Ban [bid=" + bid + ", bname=" + bname + ", xi=" + xi
				+ "]";
	}
	
}
