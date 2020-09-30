<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SelectSouvenirs</title>
        <link rel="stylesheet" href="../resources/css/registrationPageStyle.css" type="text/css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="selectSouvenirsServlet" method="post">
                    <input type="text" placeholder="value" name="value">
                    <button name="selectByID">ID</button>
                    <button name="selectByPrice">price</button>
                    <button name="selectByCountry">country</button>
                    <button name="selectByManufacturerName">manufacturer name</button>
                    <button name="selectAll">all</button>
                </form>
            </div>
        </div>
    </body>
</html>
