<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EditSouvenir</title>
        <link rel="stylesheet" href="../resources/css/registrationPageStyle.css" type="text/css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="souvenirServlet" method="post">
                    <input type="text" placeholder="id" name="id">
                    <input type="text" placeholder="name" name="name"/>
                    <input type="text" placeholder="manufacturerEmail" name="manufacturerEmail"/>
                    <input type="text" placeholder="price" name="price"/>
                    <input type="text" placeholder="manufacturer id" name="manufacturerID"/>
                    <button name="editSouvenir">edit</button>
                </form>
            </div>
        </div>
    </body>
</html>
