package com.its20.demo.entity.repository;

import java.util.LinkedList;
import java.util.List;

import com.its20.demo.entity.Course;


public class CourseRepository {

	private static List<Course> courses = new LinkedList<>();

	static {
		Course course = new Course();
		course.setId("1");
		course.setName("SK102 - Methodology of Sanskrit General");
		course.setDepartment("Department Of Sanskrit");
		courses.add(course);
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(Course course) {
		course.setName(course.getName().toLowerCase());
		course.setDepartment(course.getDepartment().toLowerCase());
		courses.add(course);
	}
	
	
}
