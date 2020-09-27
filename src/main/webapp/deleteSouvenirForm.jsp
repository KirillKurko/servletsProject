<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>AddSouvenir</title>
        <link rel="stylesheet" href="resources/css/registrationPageStyle.css" type="text/css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="souvenirServlet" method="post">
                     <input type="text" placeholder="id" name="id"/>
                     <button name="deleteSouvenir">delete</button>
                </form>
              </div>
          </div>
    </body>
</html>