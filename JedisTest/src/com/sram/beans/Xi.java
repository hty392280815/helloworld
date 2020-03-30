package com.sram.beans;

public class Xi {
	private int xid;
	private String xname;
	public int getXid() {
		return xid;
	}
	public void setXid(int xid) {
		this.xid = xid;
	}
	
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
	}
	public Xi() {
		// TODO Auto-generated constructor stub
	}
	public Xi(int xid, String xname) {
		super();
		this.xid = xid;
		this.xname = xname;
	}
	@Override
	public String toString() {
		return "Xi [xid=" + xid + ", xname=" + xname + "]";
	}
}
