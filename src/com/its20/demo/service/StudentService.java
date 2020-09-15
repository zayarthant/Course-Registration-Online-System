package com.its20.demo.service;

import java.util.List;

import com.its20.demo.entity.Student;
import com.its20.demo.entity.repository.StudentRepository;
import com.its20.demo.exception.IncorrectPassowrdException;

public class StudentService {

	private StudentRepository repository;

	public StudentService() {
		repository = new StudentRepository();
	}

	public List<Student> getUsers() {
		return repository.getUsers();
	}

	public void setUsers(Student student) {
		repository.setUsers(student);
	}

	public Student register(String name, String email, String mobile, String studentId, String password) {
		Student student = new Student();
		//convert string to long datatype
		student.setStudentId(Long.parseLong(studentId));
		student.setName(name);
		student.setEmail(email);
		student.setMobile(mobile);
		student.setPassword(password);
		repository.setUsers(student);
		return student;
	}

	public Student login(String email, String password) {
		Student student = repository.getUserByEmail(email);
		if (!student.getPassword().equals(password))
			throw new IncorrectPassowrdException("Incorrect password!");
		return student;
	}

}
