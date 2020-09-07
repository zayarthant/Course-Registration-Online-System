package com.its20.demo.entity.repository;

import java.util.LinkedList;
import java.util.List;

import com.its20.demo.entity.Student;
import com.its20.demo.exception.UserNotFoundException;

public class StudentRepository {
	private static List<Student> students = new LinkedList<>();

	static {
		Student defaultUser = new Student();
		defaultUser.setEmail("admin@mics.edu");
		defaultUser.setMobile("+95867246346");
		defaultUser.setName("Admin user");
		defaultUser.setPassword("root");
		defaultUser.setStudentId(3432L);
		students.add(defaultUser);
		Student jaya = new Student();
		jaya.setEmail("jaya@prodev.institute");
		jaya.setMobile("+95967423653");
		jaya.setName("Jaya Sahita Avadata");
		jaya.setPassword("root");
		jaya.setStudentId(948932L);
		students.add(jaya);
	}

	public List<Student> getUsers() {
		return students;
	}

	public void setUsers(Student student) {
		student.setEmail(student.getEmail().toLowerCase());
		students.add(student);
	}

	public Student getUserByEmail(String email) {
		email = email.toLowerCase();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getEmail().equals(email))
				return students.get(i);
		}
		throw new UserNotFoundException("No account with " + email);
	}
}
