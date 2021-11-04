package com.physical.biz.info;

import java.sql.Date;

// VO
public class PhysicalVO {
	private int seq;
	private String weight;
	private String height;
	private String blood;
	private String gender;
	private Date regDate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegdate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PhysicalVO [순번=" + seq + ", 체중=" + weight + ", 신장=" + height + ", 혈액형=" + blood + ", 성별="
				+ gender + ", 등록일=" + regDate + "]";
	}

	
}
