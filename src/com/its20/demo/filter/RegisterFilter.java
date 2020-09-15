package com.its20.demo.filter;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.its20.demo.exception.IncorrectPassowrdException;
import com.its20.demo.exception.InvalidEmailAddressException;

@WebFilter("/users/register")
public class RegisterFilter implements Filter {

	final String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (!request.getParameterMap().containsKey("name"))
			throw new NoSuchElementException("name not found!");

		if (!request.getParameterMap().containsKey("email"))
			throw new NoSuchElementException("email not found!");

		if (!request.getParameterMap().containsKey("mobile"))
			throw new NoSuchElementException("mobile not found!");

		if (!request.getParameterMap().containsKey("studentId"))
			throw new NoSuchElementException("studentId not found!");

		if (!request.getParameterMap().containsKey("password"))
			throw new NoSuchElementException("password not found!");

		if (!request.getParameterMap().containsKey("confirmPassword"))
			throw new NoSuchElementException("confirmPassword not found!");

		String name = request.getParameter("name").toString();
		String email = request.getParameter("email").toString();
		String mobile = request.getParameter("mobile").toString();
		String studentId = request.getParameter("studentId").toString();
		String password = request.getParameter("password").toString();
		String confirmPassword = request.getParameter("confirmPassword").toString();

		if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || studentId.isEmpty() || password.isEmpty()
				|| confirmPassword.isEmpty())
			throw new IllegalArgumentException("Email (OR)(AND) Password (OR)(AND) Name are empty");
		if (!email.matches(regex))
			throw new InvalidEmailAddressException("Invalid Email" + email);
		if (!confirmPassword.equals(password))
			throw new IncorrectPassowrdException("Password are not marge");

		chain.doFilter(request, response);
	}

}
