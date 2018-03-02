package service.impl;

import dao.UserDao;
import model.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDao userDao;

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
