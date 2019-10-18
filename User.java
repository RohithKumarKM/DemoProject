package com.mphasis.demo.model;

import java.time.LocalDate;

public class User
{
	private String email;
	private String password;
	private String name;
	private long mobile;
	private String location;
	private LocalDate dob;
	private String securityQuestion;
	private String answer;
	private int pincode;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password, String name, long mobile, String location, LocalDate dob,
			String securityQuestion, String answer, int pincode) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.location = location;
		this.dob = dob;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "email=" + email + ", password=" + password + ", name=" + name + ", mobile=" + mobile
				+ ", location=" + location + ", dob=" + dob + ", securityQuestion=" + securityQuestion + ", answer="
				+ answer + ", pincode=" + pincode;
	}
	
	
}
