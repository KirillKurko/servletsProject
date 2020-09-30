package servlets;

import DAO.implementation.ManufacturerDAOImplementation;
import DAO.implementation.SouvenirDAOImplementation;
import DAO.interfaces.ManufacturerDAO;
import DAO.interfaces.SouvenirDAO;
import model.Manufacturer;
import model.Souvenir;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManufacturerServlet extends HttpServlet {

    private final ManufacturerDAO manufacturerDAO;

    public ManufacturerServlet() {
        manufacturerDAO = new ManufacturerDAOImplementation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("createNewManufacturer") != null) {
            insertManufacturer(request, response);
        }
        else if (request.getParameter("deleteManufacturer") != null) {
            deleteManufacturer(request, response);
        }
        else if (request.getParameter("editManufacturer") != null) {
            updateManufacturer(request, response);
        }
        else if (request.getParameter("deleteSouvenirs") != null) {
            deleteManufacturerSouvenirs(request, response);
        }
    }

    private void insertManufacturer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        Manufacturer manufacturer = new Manufacturer(name, country);
        manufacturerDAO.insertManufacturer(manufacturer);
        response.sendRedirect("manufacturersList.jsp");
    }

    private void deleteManufacturer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        manufacturerDAO.deleteManufacturerSouvenirs(id);
        manufacturerDAO.deleteManufacturer(id);
        response.sendRedirect("manufacturersList.jsp");
    }

    private void deleteManufacturerSouvenirs(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        manufacturerDAO.deleteManufacturerSouvenirs(id);
        response.sendRedirect("manufacturersList.jsp");
    }

    private void updateManufacturer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        Manufacturer manufacturer = new Manufacturer(id, name, country);
        manufacturerDAO.updateManufacturer(manufacturer);
        response.sendRedirect("manufacturersList.jsp");
    }
}
