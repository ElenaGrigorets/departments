package service;

import com.mySampleApplication.client.shared.User;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    User getUserById (Integer id) throws ClassNotFoundException, SQLException;
    List<User> getUsersOfDepartment(Integer id) throws ClassNotFoundException, SQLException;
    void addUser(User user) throws ClassNotFoundException, SQLException;
    void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException;
    void removeUser(Integer id) throws ClassNotFoundException, SQLException;
}
