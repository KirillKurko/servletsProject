<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <title>Main page</title>
         <link rel="stylesheet" href="registrationPageStyle.css">
    </head>
    <body>
        <div class="login-page">
          <div class="form">
            <form class="login-form">
              <input type="text" placeholder="name"/>
              <input type="password" placeholder="password"/>
              <input type="text" placeholder="email address"/>
              <button>create</button>
              <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
            </form>
          </div>
        </div>
    </body>
</html>