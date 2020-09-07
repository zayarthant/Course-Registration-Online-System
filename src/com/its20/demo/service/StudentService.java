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

	public Student login(String email, String password) {
		Student student = repository.getUserByEmail(email);
		if (!student.getPassword().equals(password))
			throw new IncorrectPassowrdException("Incorrect password!");
		return student;
	}

}
