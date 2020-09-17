package com.its20.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.its20.demo.entity.Course;
import com.its20.demo.entity.Department;
import com.its20.demo.entity.repository.CourseRepository;
import com.its20.demo.entity.repository.DepartmentRepository;


public class CourseService {

	private CourseRepository courseRepository;
	private DepartmentRepository departmentRepository;
	

	public CourseService() {
		courseRepository = new CourseRepository();
		departmentRepository = new DepartmentRepository();
	}
	
	public List<Course> getCoursesByDepartment(int id) {
		Department department = departmentRepository.findById(id);
		return courseRepository.findByDepartment(department);
	}
	
	public List<Course> getCoursesByDepartment(String sId) {
		try {
			int id = Integer.parseInt(sId);
			return getCoursesByDepartment(id);
		}catch(Exception e) {
			
		}
		return new ArrayList<>();
	}

	public List<Course> getCourses() {
		return courseRepository.getCourses();
	}

	public void setCourses(Course course) {
		courseRepository.setCourse(course);
	}
}
