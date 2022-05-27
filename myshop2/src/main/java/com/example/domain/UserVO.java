package com.example.domain;

import java.util.Date;

public class UserVO {
	private String id;
	private String pass;
	private String name;
	private String type;
	private String tel;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pass=" + pass + ", name=" + name + ", type=" + type + ", tel=" + tel + "]";
	} 
	
	
	
	
	
}
