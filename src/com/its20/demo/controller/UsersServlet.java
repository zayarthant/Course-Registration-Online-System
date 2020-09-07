package com.its20.demo.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.its20.demo.entity.Student;
import com.its20.demo.service.StudentService;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService studentService;

	@PostConstruct
	public void init() {
		studentService = new StudentService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Iterator<Student> iterator = studentService.getUsers().iterator();
		while (iterator.hasNext())
			resp.getWriter().println(iterator.next());
	}
}
