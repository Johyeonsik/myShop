package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerVO {
	private int cus_no;
	private String cus_name;
	private String cus_tel;
	private int cus_point;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date cus_joindate;
	
	
	public int getCus_no() {
		return cus_no;
	}
	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_tel() {
		return cus_tel;
	}
	public void setCus_tel(String cus_tel) {
		this.cus_tel = cus_tel;
	}
	public int getCus_point() {
		return cus_point;
	}
	public void setCus_point(int cus_point) {
		this.cus_point = cus_point;
	}
	public Date getCus_joindate() {
		return cus_joindate;
	}
	public void setCus_joindate(Date cus_joindate) {
		this.cus_joindate = cus_joindate;
	}
	@Override
	public String toString() {
		return "CustomerVO [cus_no=" + cus_no + ", cus_name=" + cus_name + ", cus_tel=" + cus_tel + ", cus_point="
				+ cus_point + ", cus_joindate=" + cus_joindate + "]";
	}
	
	
}
