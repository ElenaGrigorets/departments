package service.impl;

import com.mySampleApplication.client.shared.User;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public UserServiceImpl() {
    };
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Integer id) throws ClassNotFoundException, SQLException {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsersOfDepartment(Integer id) throws ClassNotFoundException, SQLException {
        return userDao.getUsersOfDepartment(id);
    }

    @Override
    public void addUser(User user) throws ClassNotFoundException, SQLException {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException {
        userDao.updateUser(id, name, age);
    }

    @Override
    public void removeUser(Integer id) throws ClassNotFoundException, SQLException {
        userDao.removeUser(id);
    }
}
