package java.DAO.interfaces;

import java.model.User;
import java.util.List;

public interface UserDAO {

    void insertUser(User user);

    void updateUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id);
}
