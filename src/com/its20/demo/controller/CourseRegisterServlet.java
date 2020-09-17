package com.its20.demo.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.its20.demo.entity.Student;
import com.its20.demo.service.RegistrationService;

@WebServlet("/courseRegister")
public class CourseRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -4554950605878539846L;

	private RegistrationService service;
	
	@PostConstruct
	public void init() {
		service = new RegistrationService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (null == request.getSession().getAttribute("user")) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}

		Long studentId = ((Student) request.getSession().getAttribute("user")).getStudentId();
		String courseId = request.getParameter("courseId").toString();
		String semester = request.getParameter("semester").toString();
		String year = request.getParameter("year").toString();
		long id = service.save(studentId, courseId, semester, year);
		response.sendRedirect(request.getContextPath() + "/confirm.jsp?id="+id);
	}

}
