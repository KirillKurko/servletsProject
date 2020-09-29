package servlets;

import DAO.implementation.UserDAOImplementation;
import DAO.interfaces.UserDAO;
import model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAOImplementation();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(name, email, password);
        if (userDAO.insertUser(user)) {
            response.sendRedirect("main.jsp");
        }
        else {
            String errorMessage = "User Available";
            HttpSession session = request.getSession();
            session.setAttribute("Registration error", errorMessage);
            response.sendRedirect("registration.jsp");
        }
    }
}
