<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>User Management Application</title>
        <link rel="stylesheet" href="/resources/css/registrationPageStyle.css" type="text/css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="manufacturerServlet" method="post">
                     <input type="text" placeholder="name" name="name"/>
                     <input type="text" placeholder="country" name="country"/>
                     <button name="createNewManufacturer">create</button>
                </form>
              </div>
          </div>
    </body>
</html>