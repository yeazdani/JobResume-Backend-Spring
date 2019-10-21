package com.onlineResume.app.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("usersInfo")
public class UserInfo {
	
	private String uid;
	private String first_name;
	private String last_name;
	private String email;
	private String current_title;
	private String phone;
	private String location;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCurrent_title() {
		return current_title;
	}
	public void setCurrent_title(String current_title) {
		this.current_title = current_title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
