package com.sram.beans;

public class Student {
	private int sid;
	private String sname;
	
	private Ban ban;

	public int getSid() {
		return sid;
	}

	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}




	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Ban getBan() {
		return ban;
	}

	public void setBan(Ban ban) {
		this.ban = ban;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, Ban ban) {
		this.sid = sid;
		this.sname = sname;
		this.ban = ban;
	}

	@Override
	public String toString() {
		return "Student{" +
				"sid=" + sid +
				", sname='" + sname + '\'' +
				", ban=" + ban +
				'}';
	}
}
