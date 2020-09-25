package servlets;

import DAO.implementation.SouvenirDAOImplementation;
import DAO.interfaces.SouvenirDAO;
import model.Souvenir;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SouvenirServlet extends HttpServlet {

    private SouvenirDAO souvenirDAO;

    public SouvenirServlet() {
        souvenirDAO = new SouvenirDAOImplementation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("createNewSouvenir") != null) {
            insertSouvenir(request, response);
        }
    }

    private void insertSouvenir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String manufacturerEmail = request.getParameter("manufacturerEmail");
        float price = Float.parseFloat(request.getParameter("price"));
        int manufacturerID = Integer.parseInt(request.getParameter("manufacturerID"));
        Souvenir souvenir = new Souvenir(name, manufacturerEmail, price, manufacturerID);
        souvenirDAO.insertSouvenir(souvenir);
        response.sendRedirect("souvenirsList.jsp");
    }

    private void deleteSouvenir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        souvenirDAO.deleteSouvenir(id);
        response.sendRedirect("souvenirsList.jsp");
    }

    private void editSouvenir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Souvenir souvenir = souvenirDAO.selectSouvenir(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addSouvenirForm.jsp");
        request.setAttribute("souvenir", souvenir);
        requestDispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String manufacturerEmail = request.getParameter("manufacturerEmail");
        float price = Float.parseFloat(request.getParameter("price"));
        int manufacturerID = Integer.parseInt(request.getParameter("manufacturerID"));
        Souvenir souvenir = new Souvenir(id, name, manufacturerEmail, price, manufacturerID);
        souvenirDAO.updateSouvenir(souvenir);
        response.sendRedirect("list");
    }

    private void selectAllSouvenirs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Souvenir> souvenirs = souvenirDAO.selectAllSouvenirs();
        request.setAttribute("souvenirs", souvenirs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("souvenirsList.jsp");
        requestDispatcher.forward(request, response);
    }
}
