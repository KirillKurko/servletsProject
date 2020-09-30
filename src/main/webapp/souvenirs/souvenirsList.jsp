<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Souvenir" %>
<%@ page import="DAO.interfaces.SouvenirDAO" %>
<%@ page import="DAO.implementation.SouvenirDAOImplementation" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <title>Souvenirs</title>
        <link rel="stylesheet" href="../resources/css/registrationPageStyle.css" type="text/css">
        <link rel="stylesheet" href="../resources/css/toolbar.css" type="text/css">
        <link rel="stylesheet" href="../resources/css/table.css" type="text/css">
    </head>
    <body>
        <div class="topnav">
            <a class="active" href="addSouvenirForm.jsp">Add</a>
            <a class="active" href="deleteSouvenirForm.jsp">Delete</a>
            <a class="active" href="editSouvenirForm.jsp">Edit</a>
            <a style="float: right" class="active" href="../main.jsp">Back</a>
        </div>
         <table class="content-table">
             <thead>
             <tr>
                 <th>ID</th>
                 <th>Name</th>
                 <th>Manufacturer Email</th>
                 <th>Price</th>
                 <th>Manufacturer ID</th>
             </tr>
             </thead>
             <tbody>
             <%
                 @SuppressWarnings("unchecked")
                 List<Souvenir> souvenirs = (List<Souvenir>) request.getAttribute("souvenirs");
                 if (souvenirs == null) {
                     SouvenirDAO souvenirDAO = new SouvenirDAOImplementation();
                     souvenirs = souvenirDAO.selectAllSouvenirs();
                 }
                 for (Souvenir souvenir: souvenirs) { %>
             <tr>
                 <td><%=souvenir.getId()%></td>
                 <td><%=souvenir.getName()%></td>
                 <td><%=souvenir.getManufacturerEmail()%></td>
                 <td><%=souvenir.getPrice()%></td>
                 <td><%=souvenir.getManufacturerID()%></td>
             </tr>
             <%}%>
             </tbody>
         </table>
    </body>
</html>