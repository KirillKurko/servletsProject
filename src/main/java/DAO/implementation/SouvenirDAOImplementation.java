package DAO.implementation;

import DAO.interfaces.SouvenirDAO;
import model.Souvenir;
import utilities.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SouvenirDAOImplementation implements SouvenirDAO {

    private static final String INSERT_SOUVENIR = "INSERT INTO Souvenir(name, manufacturerEmail, price, manufacturerID) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_SOUVENIR = "UPDATE Souvenir SET name = ?, manufacturerEmail = ?, price = ? manufacturerID = ? WHERE id = ?;";
    private static final String SELECT_SOUVENIR = "SELECT * FROM Souvenir WHERE id = ?;";
    private static final String SELECT_ALL_SOUVENIRS = "SELECT * FROM Souvenir;";
    private static final String SELECT_SOUVENIRS_BY_COUNTRY = "SELECT Souvenir.* FROM Souvenir INNER JOIN Manufacturer ON Souvenir.manufacturerID = Manufacturer.id WHERE Manufacturer.country = ?;";
    private static final String SELECT_SOUVENIRS_BY_MANUFACTURER_NAME = "SELECT Souvenir.* FROM Souvenir INNER JOIN Manufacturer ON Souvenir.manufacturerID = Manufacturer.id WHERE Manufacturer.name = ?;";
    private static final String SELECT_SOUVENIRS_BY_PRICE = "SELECT * FROM Souvenir WHERE price = ?;";
    private static final String DELETE_SOUVENIR = "DELETE FROM Souvenir WHERE id = ?;";

    @Override
    public void insertSouvenir(Souvenir souvenir) {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SOUVENIR)) {
            preparedStatement.setString(1, souvenir.getName());
            preparedStatement.setString(2, souvenir.getManufacturerEmail());
            preparedStatement.setDouble(3, souvenir.getPrice());
            preparedStatement.setInt(4, souvenir.getManufacturerID());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean updateSouvenir(Souvenir souvenir) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SOUVENIR)) {
            preparedStatement.setString(1, souvenir.getName());
            preparedStatement.setString(2, souvenir.getManufacturerEmail());
            preparedStatement.setDouble(3, souvenir.getPrice());
            preparedStatement.setInt(4, souvenir.getManufacturerID());
            preparedStatement.setInt(5, souvenir.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Souvenir selectSouvenir(int id) {
        return null;
    }

    @Override
    public List<Souvenir> selectAllSouvenirs() {
        return null;
    }

    @Override
    public List<Souvenir> selectSouvenirsByCountry() {
        return null;
    }

    @Override
    public List<Souvenir> selectSouvenirsByManufacturerName(String manufacturerName) {
        return null;
    }

    @Override
    public List<Souvenir> selectSouvenirsByPrice(double price) {
        return null;
    }

    @Override
    public boolean deleteSouvenir(int id) {
        return false;
    }
}
