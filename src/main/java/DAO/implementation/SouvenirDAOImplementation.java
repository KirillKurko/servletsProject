package DAO.implementation;

import DAO.interfaces.SouvenirDAO;
import model.Souvenir;
import utilities.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Souvenir souvenir = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOUVENIR)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String manufacturerEmail = resultSet.getString("manufacturerEmail");
                double price = resultSet.getDouble("price");
                int manufacturerID = resultSet.getInt("manufacturerID");
                souvenir = new Souvenir(id, name, manufacturerEmail, price, manufacturerID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return souvenir;
    }

    @Override
    public List<Souvenir> selectAllSouvenirs() {
        List<Souvenir> souvenirs = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SOUVENIRS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String manufacturerEmail = resultSet.getString("manufacturerEmail");
                double price = resultSet.getDouble("price");
                int manufacturerID = resultSet.getInt("manufacturerID");
                souvenirs.add(new Souvenir(id, name, manufacturerEmail, price, manufacturerID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return souvenirs;
    }

    @Override
    public List<Souvenir> selectSouvenirsByCountry(String country) {
        List<Souvenir> souvenirs = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOUVENIRS_BY_COUNTRY)) {
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String manufacturerEmail = resultSet.getString("manufacturerEmail");
                double price = resultSet.getDouble("price");
                int manufacturerID = resultSet.getInt("manufacturerID");
                souvenirs.add(new Souvenir(id, name, manufacturerEmail, price, manufacturerID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return souvenirs;
    }

    @Override
    public List<Souvenir> selectSouvenirsByManufacturerName(String manufacturerName) {
        List<Souvenir> souvenirs = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOUVENIRS_BY_COUNTRY)) {
            preparedStatement.setString(1, manufacturerName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String manufacturerEmail = resultSet.getString("manufacturerEmail");
                double price = resultSet.getDouble("price");
                int manufacturerID = resultSet.getInt("manufacturerID");
                souvenirs.add(new Souvenir(id, name, manufacturerEmail, price, manufacturerID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return souvenirs;
    }

    @Override
    public List<Souvenir> selectSouvenirsByPrice(double price) {
        List<Souvenir> souvenirs = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOUVENIRS_BY_COUNTRY)) {
            preparedStatement.setDouble(1, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String manufacturerEmail = resultSet.getString("manufacturerEmail");
                int manufacturerID = resultSet.getInt("manufacturerID");
                souvenirs.add(new Souvenir(id, name, manufacturerEmail, price, manufacturerID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return souvenirs;
    }

    @Override
    public boolean deleteSouvenir(int id) {
        return false;
    }
}
