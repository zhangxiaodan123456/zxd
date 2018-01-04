package com.rb.sz.cmb.bean;

public class User {
	private String usrNam;
	private String usrId;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String usrNam, String usrId) {
		super();
		this.usrNam = usrNam;
		this.usrId = usrId;
	}
	@Override
	public String toString() {
		return "User [usrNam=" + usrNam + ", usrId=" + usrId + "]";
	}
	public String getUsrNam() {
		return usrNam;
	}
	public void setUsrNam(String usrNam) {
		this.usrNam = usrNam;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
