package com.its20.demo.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.its20.demo.entity.Student;
import com.its20.demo.service.StudentService;

@WebServlet("/users/login")
public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService studentService;

	@PostConstruct
	public void init() {
		studentService = new StudentService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email").toString();
		String password = req.getParameter("password").toString();
		Student student = studentService.login(email, password);
		req.getSession().setAttribute("user", student);
		resp.sendRedirect( req.getContextPath() + "/dashboard.jsp");

	}

}
