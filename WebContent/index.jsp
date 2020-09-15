<%
        	if(null != request.getSession().getAttribute("user"))
        		response.sendRedirect( request.getContextPath() + "/dashboard.jsp");
%>
<%-- <%
        	if(null != request.getSession().getAttribute("cours"))
        		response.sendRedirect( request.getContextPath() + "/dashboard.jsp");
%> --%>

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

        <section class="w3-margin">
            <div class="w3-quarter">
                <div class="w3-card">
                    <div class="w3-light-green w3-center">
                        <h3>Login</h3>
                    </div>
                    <form method="get" action="users/login" class="w3-padding">
                        <p>
                            <label>Email</label>
                            <input name="email" class="w3-input w3-border" type="text" placeholder="email"/>
                        </p>
                        <p>
                            <label>Password</label>
                            <input name="password" class="w3-input w3-border" type="password" placeholder="password"/>
                        </p>
                        <p class="w3-center">
                            <button class="w3-button w3-light-green">Login</button>
                        </p>
                    </form>
                </div>
            </div>
            <div class="w3-threequarter">
                <h3 class="w3-center"><b>Student Account Register</b></h3>
                <hr/>
                <form method="post" action="users/register" class="w3-clear w3-padding">
                    <div class="w3-half w3-padding">
                        <p>
                            <label>Name</label>
                            <input class="w3-input w3-border" type="text" placeholder="name" name="name"/>
                        </p>
                        <p>
                            <label>Email</label>
                            <input class="w3-input w3-border" type="email" placeholder="email" name="email"/>
                        </p>
                        <p>
                            <label>Mobile</label>
                            <input class="w3-input w3-border" type="text" placeholder="phone" name="mobile"/>
                        </p>

                    </div>
                    <div class="w3-half w3-padding">
                        <p>
                            <label>Student ID</label>
                            <input class="w3-input w3-border" type="number" placeholder="student id" name="studentId"/>
                        </p>
                        <p>
                            <label>Password</label>
                            <input class="w3-input w3-border" type="password" placeholder="password" name="password"/>
                        </p>
                        <p>
                            <label>Password</label>
                            <input class="w3-input w3-border" type="password" placeholder="confirm password" name="confirmPassword"/>
                        </p>
                    </div>
                    
                     <p class="w3-center">
                    <button class="w3-button w3-light-green">Register</button>
                </p>
                </form>
               
            </div>
        </section>

        <footer class="w3-light-green w3-container w3-padding-32 w3-bottom">
            <p class="w3-text-white">&copy; Dekastan State University (Civitas Universitas Dekastan)</p>
        </footer>
    </body>
</html>
