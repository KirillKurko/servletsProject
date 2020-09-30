package servlets.souvenirServlets;

import DAO.implementation.SouvenirDAOImplementation;
import DAO.interfaces.SouvenirDAO;
import model.Souvenir;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SelectSouvenirsServlet extends HttpServlet {

    private final SouvenirDAO souvenirDAO;

    public SelectSouvenirsServlet() {
        souvenirDAO = new SouvenirDAOImplementation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("selectByID") != null) {
            selectByID(request, response);
        }
        else if (request.getParameter("selectByPrice") != null) {
            selectByPrice(request, response);
        }
        else if (request.getParameter("selectByCountry") != null) {
            selectByCountry(request, response);
        }
        else if (request.getParameter("selectByManufacturerName") != null) {
            selectByManufacturerName(request, response);
        }
        else {
            selectAllSouvenirs(request, response);
        }
    }

    private void selectAllSouvenirs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Souvenir> souvenirs = new ArrayList<>(souvenirDAO.selectAllSouvenirs());
        request.setAttribute("souvenirs", souvenirs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("souvenirsList.jsp");
        requestDispatcher.forward(request, response);
    }

    private void selectByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("value"));
        ArrayList<Souvenir> souvenirs = new ArrayList<>(souvenirDAO.selectSouvenir(id));
        request.setAttribute("souvenirs", souvenirs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("souvenirsList.jsp");
        requestDispatcher.forward(request, response);
    }

    private void selectByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("value"));
        ArrayList<Souvenir> souvenirs = new ArrayList<>(souvenirDAO.selectSouvenirsByPrice(price));
        request.setAttribute("souvenirs", souvenirs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("souvenirsList.jsp");
        requestDispatcher.forward(request, response);
    }

    private void selectByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("value");
        ArrayList<Souvenir> souvenirs = new ArrayList<>(souvenirDAO.selectSouvenirsByCountry(country));
        request.setAttribute("souvenirs", souvenirs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("souvenirsList.jsp");
        requestDispatcher.forward(request, response);
    }

    private void selectByManufacturerName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manufacturerName = request.getParameter("value");
        ArrayList<Souvenir> souvenirs = new ArrayList<>(souvenirDAO.selectSouvenirsByManufacturerName(manufacturerName));
        request.setAttribute("souvenirs", souvenirs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("souvenirsList.jsp");
        requestDispatcher.forward(request, response);
    }
}

