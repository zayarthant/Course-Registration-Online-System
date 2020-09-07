package com.its20.demo.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.its20.demo.entity.User;
import com.its20.demo.service.UserService;

@WebServlet("/users/login")
public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService;

	@PostConstruct
	public void init() {
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email").toString();
		String password = req.getParameter("password").toString();
		User user = userService.login(email, password);
		req.getSession().setAttribute("user", user);
		resp.sendRedirect( req.getContextPath() + "/dashboard.jsp");
	}

}
