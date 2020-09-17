<%@page import="com.its20.demo.entity.Registration"%>
<%@page import="com.its20.demo.service.RegistrationService"%>
<%@page import="com.its20.demo.entity.Student"%>
<%!Student user;%>
<%!RegistrationService registrationService = new RegistrationService();%>
<%
	if(null == request.getSession().getAttribute("user")){
        		response.sendRedirect( request.getContextPath() + "/index.jsp");
        		return;
     }else{
    	 user = (Student) request.getSession().getAttribute("user");
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
            </div>
        </section>
        <section>
            <h3 class="w3-center"><b>Registration Summits</b></h3>
            <div class="w3-container">
                <table class="w3-table w3-border">
                    <thead>
                        <tr class="w3-light-green">
                            <th>ID</th>
                            <th>Course</th>
                            <th>Semester</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    
                    <%for(Registration registration: registrationService.getRegistrationByStudentId(user.getStudentId())){
                    	%>
                    	<tr>
	                        <td><%=registration.getId() %></td>
	                        <td><%=registration.getCourse().getId() %> - <%=registration.getCourse().getName() %></td>
	                        <td><%=registration.getSemister() + " " + registration.getYear()%></td>
	                        <td><%=registration.getStatus()%></td>
                    	</tr>
                    <%} %>
                </table>
            </div>
            <div class="w3-container w3-margin w3-center">
            	<a href="<%=request.getContextPath()%>/dashboard.jsp" class="w3-button w3-light-green"> Dashboard</a>
        	</div>
        </section>
        <footer class="w3-light-green w3-container w3-padding-32 w3-bottom">
            <p class="w3-text-white">&copy; Dekastan State University (Civitas Universitas Dekastan)</p>
        </footer>
    </body>
</html>
