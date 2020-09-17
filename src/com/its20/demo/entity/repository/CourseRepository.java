package com.its20.demo.entity.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.its20.demo.entity.Course;
import com.its20.demo.entity.Department;
import com.its20.demo.exception.UserNotFoundException;

public class CourseRepository {

	private static List<Course> courses = new ArrayList<>();

	{
		DepartmentRepository departmentRepository = new DepartmentRepository();
		Department sanskritDepartment = departmentRepository.findById(1);
		Department historyDepartment = departmentRepository.findById(2);

		Course SK103 = new Course();
		SK103.setDepartment(sanskritDepartment);
		SK103.setId("SK103");
		SK103.setName("Literature in Sanskrit Language");

		Course SK105 = new Course();
		SK105.setDepartment(sanskritDepartment);
		SK105.setId("SK105");
		SK105.setName("Communication skills in Sanskrit");

		Course SK428 = new Course();
		SK428.setDepartment(sanskritDepartment);
		SK428.setId("SK428");
		SK428.setName("Historical Survey of Sanskrit Literature");

		Course H248 = new Course();
		H248.setDepartment(historyDepartment);
		H248.setId("H248");
		H248.setName("Modern Japan");

		Course H633 = new Course();
		H633.setDepartment(historyDepartment);
		H633.setId("H633");
		H633.setName("Chinese Architecture throught History");

		Course H342 = new Course();
		H342.setDepartment(historyDepartment);
		H342.setId("H342");
		H342.setName("Modern Burma(Myanmar)");

		courses.addAll(Arrays.asList(SK103, SK105, SK428, H248, H342, H633));
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourse(Course course) {
		courses.add(course);
	}
	
	public Course getById(String id) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equalsIgnoreCase(id))
				return courses.get(i);
		}
		throw new UserNotFoundException("No course with " + id);
	}

	public List<Course> findByDepartment(Department department) {
		List<Course> list = new ArrayList<>();
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getDepartment().getId() == department.getId())
				list.add(courses.get(i));
		}
		return list;
	}

}
