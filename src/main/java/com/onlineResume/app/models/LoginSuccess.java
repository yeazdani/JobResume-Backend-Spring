package com.onlineResume.app.models;

public class LoginSuccess {
	private String id;
	private String first_name;
	private String last_name;
	private String email;
	private String token;
	private String message;

	public LoginSuccess(
			String id, String first_name,String last_name,String email, String token, String message
			) {
		this.id = id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;
		this.token = token;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
