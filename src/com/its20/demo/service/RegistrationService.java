package com.its20.demo.service;

import java.util.List;
import java.util.Random;

import com.its20.demo.entity.Course;
import com.its20.demo.entity.Registration;
import com.its20.demo.entity.Student;
import com.its20.demo.entity.repository.CourseRepository;
import com.its20.demo.entity.repository.RegistrationRepository;
import com.its20.demo.entity.repository.StudentRepository;

public class RegistrationService {
	private RegistrationRepository registrationRepository;
	private StudentRepository studentRepository;
	private CourseRepository courseRepository;
	
	public RegistrationService() {
		registrationRepository = new RegistrationRepository();
		studentRepository = new StudentRepository();
		courseRepository = new CourseRepository();
	}
	
	public List<Registration> getRegistrationByStudentId(long id) {
		return registrationRepository.getRegistrationByStudentId(id);
	}
	
	public Registration getById(long id) {
		return registrationRepository.getById(id);
	}
	
	public long save(long studentId, String courseId, String semister, String year) {
		Student student = studentRepository.getUserById(studentId);
		Course course = courseRepository.getById(courseId);
		Registration registration = new Registration();
		registration.setStudent(student);
		registration.setCourse(course);
		registration.setSemister(semister);
		registration.setYear(year);
		registration.setStatus("Pending");
		registration.setId(new Random().nextInt());
		registrationRepository.setRegistration(registration);
		return registration.getId();
	}
	
	
}
