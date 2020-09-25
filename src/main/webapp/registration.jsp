<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <title>Registration page</title>
         <link rel="stylesheet" href="resources/css/registrationPageStyle.css" type="text/css">
    </head>
    <body>
        <div class="login-page">
          <div class="form">
            <form class="login-form" action="registerServlet" method="post">
              <input type="text" placeholder="name" name="name"/>
              <input type="password" placeholder="password" name="password"/>
              <input type="text" placeholder="email address" name="email"/>
              <button>create</button>
              <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
            </form>
          </div>
        </div>
    </body>
</html>