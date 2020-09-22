package java.DAO.implementation;

import javax.xml.crypto.Data;
import java.DAO.interfaces.ManufacturerDAO;
import java.model.Manufacturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.utilities.DatabaseUtility;

public class ManufacturerDAOImplementation implements ManufacturerDAO {

    private static final String INSERT_MANUFACTURER = "INSERT INTO User(name, country) VALUES (?, ?);";
    private static final String UPDATE_MANUFACTURER = "UPDATE Manufacturer SET name = ?, country = ? WHERE id = ?;";
    private static final String SELECT_MANUFACTURER = "SELECT * FROM Manufacturer WHERE id = ?;";
    private static final String SELECT_ALL_MANUFACTURER = "SELECT * FROM Manufacturer;";
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
        return null;
    }

    @Override
    public List<Manufacturer> selectAllManufacturers() {
        return null;
    }

    @Override
    public List<Manufacturer> selectManufacturersBySouvenirsDate(Calendar date) {
        return null;
    }

    @Override
    public boolean deleteManufacturer(int id) {
        return false;
    }

    @Override
    public void deleteManufacturerSouvenirs(int id) {

    }
}
