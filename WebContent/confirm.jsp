<%@page import="com.its20.demo.entity.Student"%>
<%@page import="com.its20.demo.service.RegistrationService"%>
<%@page import="com.its20.demo.entity.Registration"%>
<%@page import="com.its20.demo.service.CourseService"%>
<%!Student user;%>
<%!RegistrationService registrationService = new RegistrationService();%>
<%!Registration registration; %>
<%
	if(null == request.getParameter("id") || null == request.getSession().getAttribute("user")){
        response.sendRedirect( request.getContextPath() + "/index.jsp");
        return;
     }else{
    	 long id = Long.parseLong(request.getParameter("id"));
    	 registration = registrationService.getById(id);
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
        <section class="w3-container w3-margin w3-clear">
            <h3 class="w3-center"> <b>Register Information</b> </h3>
            <p>
                Registration ID : <b><%=registration.getId()%>></b>
            </p>
            <p>
                Course : <b><%=registration.getCourse().getId() %> - <%=registration.getCourse().getName() %></b>
            </p>
            <p>
                Semester : <b><%=registration.getSemister() + " " + registration.getYear()%></b>
            </p>
        </section>
        <div class="w3-container w3-margin w3-center">
            <a href="<%=request.getContextPath()%>/dashboard.jsp" class="w3-button w3-light-green"> Dashboard</a>
        </div>
        <footer class="w3-light-green w3-container w3-padding-32 w3-bottom">
            <p class="w3-text-white">&copy; Dekastan State University (Civitas Universitas Dekastan)</p>
        </footer>
    </body>
</html>
