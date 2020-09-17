package com.its20.demo.entity;

public class Course {

	private String id;
	private String name;
	private Department department;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {

		return "<h1>Course Information</h1>" + "<p>" + name + "</p>" ;
	}
	
}
