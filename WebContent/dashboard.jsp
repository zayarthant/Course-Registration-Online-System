
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
                    <p>83 of 120 Credit</p>
                    <p>Undergraduate</p>
                    <p><a class="w3-text-red" href="<%=request.getContextPath()%>/users/logout">Logout</a></p>
                    <p><a class="w3-text-blue" href="<%=request.getContextPath()%>/registerList.jsp">Register Courses</a></p>
                </div>
            </section>
            <section>
                <form class="w3-card">
                    <h3 class="w3-light-green w3-padding w3-text-white">Registration</h3>
                    <div class="w3-container w3-clear">
                        <p>
                            <label>Department</label>
                            <select class="w3-select w3-border" name="option">
                                <option value="" disabled selected></option>
                                <option value="1">Department Of Sanskrit</option>
                                <option value="2">Department Of Pali</option>
                                <option value="3">Department Of History</option>
                            </select>
                        </p>
                        <p>
                            <label>Course</label>
                            <select class="w3-select w3-border" name="option">
                                <option value="" disabled selected></option>
                                <option value="1"></option>
                                <option value="2">SK103 - Literature in Sanskrit Language</option>
                                <option value="2">SK105 - Communication skills in Sanskrit</option>
                                <option value="3">SK428 - Historical Survey of Sanskrit Literature</option>
                            </select>
                        </p>
                        <div class="w3-clear">
                            <div class="w3-half">
                                <p>
                                    <label>Semester</label>
                                <div class="w3-center w3-half">
                                    <input class="w3-radio" type="radio" name="gender" value="male" checked>
                                    <label>Winter</label>
                                </div>
                                <div class="w3-center w3-half">
                                    <input class="w3-radio" type="radio" name="gender" value="female">
                                    <label>Summer</label>
                                </div>
                                </p>
                            </div>
                            <div class="w3-half">
                                <p>
                                    <label>Year</label>
                                <div>
                                    <select class="w3-select w3-border" name="option">
                                        <option value="1">2021</option>
                                        <option value="2">2022</option>
                                        <option value="3">2023</option>
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
