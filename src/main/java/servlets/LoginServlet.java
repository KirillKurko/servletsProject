package servlets;

import DAO.implementation.UserDAOImplementation;
import DAO.interfaces.UserDAO;
import model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAOImplementation();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = userDAO.selectUser(name, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("Authorized user", user);
            response.sendRedirect("main.jsp");
        }
        else {
            String errorMessage = "User not found";
            HttpSession session = request.getSession();
            session.setAttribute("Login error", errorMessage);
            response.sendRedirect("index.jsp");
        }
    }
}
