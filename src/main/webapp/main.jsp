<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <title>Main page</title>
        <link rel="stylesheet" href="resources/css/registrationPageStyle.css" type="text/css">
    </head>
        <body>
            <h2>Hello World!</h2>
            <a href="index.jsp">Login</a>
            <form action="logoutServlet" method="post"><button text="Logout"/></form>
            <a href="souvenirs/souvenirsList.jsp">souvenirs</a>
            <a href="manufacturers/manufacturersList.jsp">manufacturers</a>
        </body>
</html>