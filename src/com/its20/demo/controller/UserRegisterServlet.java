package com.its20.demo.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.its20.demo.service.StudentService;


@WebServlet("/users/register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService studentService;

	@PostConstruct
	public void init() {
		studentService = new StudentService();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String email = req.getParameter("email").toString();
		  String mobile = req.getParameter("mobile").toString();
		  String name = req.getParameter("name").toString();
		  String studentId = req.getParameter("studentId");
		  String password = req.getParameter("password").toString();
		  studentService.register(name, email, mobile, studentId, password);
		  resp.sendRedirect( req.getContextPath() + "/users"); 
	}

}
