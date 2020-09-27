<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Souvenir" %>
<%@ page import="DAO.interfaces.SouvenirDAO" %>
<%@ page import="DAO.implementation.SouvenirDAOImplementation" %>
<html>
    <head>
        <title>Souvenirs</title>
        <link rel="stylesheet" href="resources/css/registrationPageStyle.css" type="text/css">
    </head>
    <body>
         <div class="login-page">
             <div class="form">
                      <form class="login-form" action="souvenirServlet" method="post">
                      <button name="addSouvenirButton">Add</button>
                      <button name="deleteSouvenirButton">Delete</button>
                      <button name="searchSouvenirButton">Search</button>
                      <button name="editSouvenirButton">Edit</button>
                  </form>
             </div>
         </div>
         <div class="container">
            <table>
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
                      <% SouvenirDAO souvenirDAO = new SouvenirDAOImplementation();
                      List<Souvenir> souvenirs = souvenirDAO.selectAllSouvenirs();
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
          </div>
    </body>
</html>