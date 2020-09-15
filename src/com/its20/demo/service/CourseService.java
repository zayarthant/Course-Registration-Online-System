package com.its20.demo.service;

import java.util.List;

import com.its20.demo.entity.Course;
import com.its20.demo.entity.repository.CourseRepository;


public class CourseService {

	private CourseRepository repository;

	public CourseService() {
		repository = new CourseRepository();
	}

	public List<Course> getCourses() {
		return repository.getCourses();
	}

	public void setCourses(Course course) {
		repository.setCourses(course);
	}
}
