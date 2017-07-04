package com.iotek.entity;

import java.io.Serializable;


public class User implements Serializable {
	private Integer uId;
	private String uName;
	private String uPass;
	private String uSex;
	private Integer uAge;
	private Integer uLevel;
	private int upoint;

	public User() {
	}

	public User(Integer uId, String uName, String uPass, String uSex, Integer uAge, Integer uLevel, int upoint) {
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
		this.uSex = uSex;
		this.uAge = uAge;
		this.uLevel = uLevel;
		this.upoint = upoint;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	public Integer getuAge() {
		return uAge;
	}

	public void setuAge(Integer uAge) {
		this.uAge = uAge;
	}

	public Integer getuLevel() {
		return uLevel;
	}

	public void setuLevel(Integer uLevel) {
		this.uLevel = uLevel;
	}

	public int getUpoint() {
		return upoint;
	}

	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}

	@Override
	public String toString() {
		return "User{" +
				"uId=" + uId +
				", uName='" + uName + '\'' +
				", uPass='" + uPass + '\'' +
				", uSex='" + uSex + '\'' +
				", uAge=" + uAge +
				", uLevel=" + uLevel +
				", upoint=" + upoint +
				'}';
	}
}
