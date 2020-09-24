<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <title>Login page</title>
         <link rel="stylesheet" href="registrationPageStyle.css">
    </head>
    <body>
        <div class="login-page">
          <div class="form">
            <form class="login-form" action="loginServlet" method="post">
              <input type="text" placeholder="username" name="name"/>
              <input type="password" placeholder="password" name="password"/>
              <button>login</button>
              <p class="message">Not registered? <a href="registration.jsp">Create an account</a></p>
            </form>
          </div>
        </div>
    </body>
</html>