package com.its20.demo.entity;

public class Student {
	private Long studentId;
	private String name;
	private String email;
	private String password;
	private String mobile;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {

		return "<h1>Student Information</h1>" + "<p>" + studentId + "</p>" + "<p>" + name + "</p>" + "<p>" + email
				+ "</p>" + "<p>" + mobile + "</p>";
	}

	

}
