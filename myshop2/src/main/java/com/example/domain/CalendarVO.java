package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CalendarVO {
	private int cno; 
	private String title; 
	private String writer; 
	private int cus_no;
	private String content; 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private String start; 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private String end; 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private String reserveDate; 
	private int allday;
	private String cus_name;
	
	
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	public int getCus_no() {
		return cus_no;
	}
	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getAllday() {
		return allday;
	}
	public void setAllday(int allday) {
		this.allday = allday;
	}
	@Override
	public String toString() {
		return "CalendarVO [cno=" + cno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", start=" + start + ", end=" + end + ", allday=" + allday + "]";
	}
	
	
}
