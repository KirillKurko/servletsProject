package DAO.implementation;

import DAO.interfaces.ManufacturerDAO;
import model.Manufacturer;
import utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ManufacturerDAOImplementation implements ManufacturerDAO {

    private static final String INSERT_MANUFACTURER = "INSERT INTO User(name, country) VALUES (?, ?);";
    private static final String UPDATE_MANUFACTURER = "UPDATE Manufacturer SET name = ?, country = ? WHERE id = ?;";
    private static final String SELECT_MANUFACTURER = "SELECT * FROM Manufacturer WHERE id = ?;";
    private static final String SELECT_ALL_MANUFACTURERS = "SELECT * FROM Manufacturer;";
    private static final String DELETE_MANUFACTURERS_BY_SOUVENIRS_DATE = "SELECT * FROM Manufacturer.* FROM Manufacturer INNER JOIN Souvenir ON Manufacturer.id = Souvenir.manufacturerID WHERE Souvenir.manufacturingDate = ?;";
    private static final String DELETE_MANUFACTURER = "DELETE FROM Manufacturer WHERE id = ?;";
    private static final String DELETE_MANUFACTURER_SOUVENIRS = "DELETE FROM Souvenir WHERE manufacturerID = ?;";

    @Override
    public void insertManufacturer(Manufacturer manufacturer) {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MANUFACTURER)) {
            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean updateManufacturer(Manufacturer manufacturer) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MANUFACTURER)) {
            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());
            preparedStatement.setInt(3, manufacturer.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Manufacturer selectManufacturer(int id) {
        Manufacturer manufacturer = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MANUFACTURER)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                manufacturer = new Manufacturer(id, name, country);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return manufacturer;
    }

    @Override
    public List<Manufacturer> selectAllManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MANUFACTURERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                manufacturers.add(new Manufacturer(id, name, country));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return manufacturers;
    }

    //TODO implement this and check sql query
    @Override
    public List<Manufacturer> selectManufacturersBySouvenirsDate(Calendar date) {
        return null;
    }

    @Override
    public boolean deleteManufacturer(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MANUFACTURER)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }

    //TODO think about to remove this method to souvenir DAO
    @Override
    public void deleteManufacturerSouvenirs(int id) {
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MANUFACTURER_SOUVENIRS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
