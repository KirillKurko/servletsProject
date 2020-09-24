package DAO.interfaces;

import model.User;
import java.util.List;

public interface UserDAO {

    boolean insertUser(User user);

    boolean updateUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id);
}
