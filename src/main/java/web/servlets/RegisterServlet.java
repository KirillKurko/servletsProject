package java.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.DAO.implementation.UserDAOImplementation;
import java.DAO.interfaces.UserDAO;
import java.io.IOException;
import java.model.User;

public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAOImplementation();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(name, email, password);
        if (userDAO.insertUser(user)) {
            response.sendRedirect("index.jsp");
        }
        else {
            String errorMessage = "User Available";
            HttpSession session = request.getSession();
            session.setAttribute("Registration error", errorMessage);
            response.sendRedirect("registration.jsp");
        }
    }
}
