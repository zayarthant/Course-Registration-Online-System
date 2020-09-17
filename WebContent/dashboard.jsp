<%@page import="com.its20.demo.entity.Course"%>
<%@page import="com.its20.demo.service.CourseService"%>
<%@page import="com.its20.demo.entity.Department"%>
<%@page import="com.its20.demo.service.DepartmentService"%>
<%@ page import="com.its20.demo.entity.Student"%>
<%!Student user;%>

<%
	if(null == request.getSession().getAttribute("user")){
        		response.sendRedirect( request.getContextPath() + "/index.jsp");
        		return;
     }else{
    	 user = (Student) request.getSession().getAttribute("user");
     }
        		
%>
<%!DepartmentService departmentService = new DepartmentService();%>
<%!CourseService courseService = new CourseService();%>
<%!
	private String isSelected(int id, String requestId){
		if(null == requestId)
			return "";
		if(Integer.toString(id).equals(requestId))
			return "selected";
		return "";
	}
%>


<html>
    <head>
        <title>Dekastan State University</title>
        <meta charset="UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="img/xxs.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="style/w3.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header class="w3-light-green w3-container">
            <h1 class="w3-text-white">Course Registration Online System <span class="w3-tag w3-yellow w3-small">(CRO)</span> </h1>
        </header>
        <section class="w3-container w3-margin w3-clear">
            <section id="studentInfo" class="w3-padding w3-clear">
                <div class="w3-half">
                    <p>Username : <%=user.getName() %></p>
                    <p>Id : <%=user.getStudentId() %></p>
                    <p>Mobile : <%=user.getMobile() %></p>
                    <p>Mail : <%=user.getEmail() %></p>
                </div>
                <div class="w3-half">
                    <p></p>
                    <p></p>
                    <p><a class="w3-text-red" href="<%=request.getContextPath()%>/users/logout">Logout</a></p>
                    <p><a class="w3-text-blue" href="<%=request.getContextPath()%>/registerList.jsp">Register Courses</a></p>
                </div>
            </section>
            <section>
                <form class="w3-card" method="post" action="<%=request.getContextPath()%>/courseRegister">
                    <h3 class="w3-light-green w3-padding w3-text-white">Registration</h3>
                    <div class="w3-container w3-clear">
                        <p>
                            <label>Department</label>
                            <select class="w3-select w3-border" name="option" onchange="window.location=this.options[this.selectedIndex].value">
                            	<option disabled="disabled" <%=null == request.getParameter("department")?"selected":""%>/>
						      <%for(Department department : departmentService.getDepartments()) { %>
						      	<option 
						      		value="<%=request.getRequestURL()+"?department="+department.getId()%>" 
						      		<%=isSelected(department.getId(),request.getParameter("department"))%>
						      	>
						      		<%=department.getName() %>
						      	</option>
						      <%}%>
                            </select>
                        </p>
                        <p>
                            <label>Course</label>
                            <select class="w3-select w3-border" name="courseId">
                                <% for(Course course : courseService.getCoursesByDepartment(request.getParameter("department"))){%>
		                                <option value="<%=course.getId() %>">
								      		<%=course.getId() %> - <%=course.getName() %>
								      	</option>
                                <%}%>
                            </select>
                        </p>
                        <div class="w3-clear">
                            <div class="w3-half">
                                <p>
                                    <label>Semester</label>
                                <div class="w3-center w3-half">
                                    <input class="w3-radio" type="radio" name="semester" value="Winter" checked>
                                    <label>Winter</label>
                                </div>
                                <div class="w3-center w3-half">
                                    <input class="w3-radio" type="radio" name="semester" value="Summer">
                                    <label>Summer</label>
                                </div>
                                </p>
                            </div>
                            <div class="w3-half">
                                <p>
                                    <label>Year</label>
                                <div>
                                    <select class="w3-select w3-border" name="year">
                                        <option value="2021">2021</option>
                                        <option value="2022">2022</option>
                                        <option value="2023">2023</option>
                                    </select>
                                </div>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="w3-clear w3-padding w3-right-align">
                        <hr/>
                        <input type="submit" class="w3-button w3-light-green" value="Summit Registration"/>
                    </div>
                </form>
            </section>
        </section>
        <footer class="w3-light-green w3-container w3-padding-32">
            <p class="w3-text-white">&copy; Dekastan State University (Civitas Universitas Dekastan)</p>
        </footer>
    </body>
</html>
