package com.its20.demo.filter;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/courseRegister")
public class CourseRegisterFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if (!request.getParameterMap().containsKey("courseId"))
			throw new NoSuchElementException("courseId not found!");
		if (!request.getParameterMap().containsKey("semester"))
			throw new NoSuchElementException("semester not found!");
		if (!request.getParameterMap().containsKey("year"))
			throw new NoSuchElementException("year not found!");
		
		String courseId = request.getParameter("courseId").toString();
		String semester = request.getParameter("semester").toString();
		String year = request.getParameter("year").toString();
		
		if(courseId.isEmpty() || semester.isEmpty() || year.isEmpty())
			throw new IllegalArgumentException("Course (OR)(AND) Semester (OR)(AND) Year are empty");
		
		chain.doFilter(request, response);
	}

}
