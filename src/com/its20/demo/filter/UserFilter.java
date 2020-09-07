package com.its20.demo.filter;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.its20.demo.exception.InvalidEmailAddressException;

@WebFilter("/users/login")
public class UserFilter implements Filter {

	final String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (!request.getParameterMap().containsKey("email"))
			throw new NoSuchElementException("email not found!");

		if (!request.getParameterMap().containsKey("password"))
			throw new NoSuchElementException("password not found!");

		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();

		if (email.isEmpty() || password.isEmpty())
			throw new IllegalArgumentException("Email (OR)(AND) Password are emptry");
		if (!email.matches(regex))
			throw new InvalidEmailAddressException("Invalid Email");

		chain.doFilter(request, response);
	}

}
