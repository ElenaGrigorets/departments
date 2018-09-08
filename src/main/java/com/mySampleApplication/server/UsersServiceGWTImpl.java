package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.UsersServiceGWT;
import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.User;
import dao.UserDao;
import dao.impl.UserDaoMysqlImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dik81 on 03.07.18.
 */
public class UsersServiceGWTImpl extends RemoteServiceServlet implements UsersServiceGWT {
    @Override
    public String getMessage(String msg) {
        return null;
    }

    @Override
    public List<User> getUsersOfDepartment(Integer id) {
        UserDao userDao = new UserDaoMysqlImpl();
        try {
            return userDao.getUsersOfDepartment(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        UserDao userDao = new UserDaoMysqlImpl();
        try {
            userDao.getUserById(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        UserDao userDao = new UserDaoMysqlImpl();
        try {
            userDao.addUser(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUser(Integer id) {
        UserDao userDao = new UserDaoMysqlImpl();
        try {
            userDao.removeUser(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        UserDao userDao = new UserDaoMysqlImpl();
        try {
            userDao.updateUser(user.getId(), user.getName(), user.getAge());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
