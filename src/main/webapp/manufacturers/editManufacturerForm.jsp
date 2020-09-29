<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EditManufacturer</title>
        <link rel="stylesheet" href="../resources/css/registrationPageStyle.css" type="text/css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="manufacturerServlet" method="post">
                    <input type="text" placeholder="id" name="id">
                    <input type="text" placeholder="name" name="name"/>
                    <input type="text" placeholder="country" name="country"/>
                    <button name="editManufacturer">edit</button>
                </form>
            </div>
        </div>
    </body>
</html>
