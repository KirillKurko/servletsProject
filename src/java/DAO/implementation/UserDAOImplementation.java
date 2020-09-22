package java.DAO.implementation;

import java.DAO.interfaces.UserDAO;
import java.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.utilities.DatabaseUtility;

public class UserDAOImplementation implements UserDAO {

    private static final String INSERT_USER = "INSERT INTO User(username, password) VALUES (?, ?);";
    private static final String UPDATE_USER = "UPDATE User SET username = ?, password = ? WHERE id = ?;";
    private static final String SELECT_USER = "SELECT * FROM User WHERE id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM User;";
    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?;";

    @Override
    public void insertUser(User user) {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User selectUser(int id) {

    }

    @Override
    public List<User> selectAllUsers() {

    }

    @Override
    public boolean deleteUser(int id) {

    }
}
