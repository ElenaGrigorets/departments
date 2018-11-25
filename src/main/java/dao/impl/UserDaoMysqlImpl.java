package dao.impl;

import com.mySampleApplication.client.shared.User;
import dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class UserDaoMysqlImpl implements UserDao {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/departments";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement preparedStatement = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public User getUserById(Integer id) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        User user = null;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            String sql = "SELECT name, age, departmentId FROM users WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int departmentId = rs.getInt("departmentId");
                user = new User(name, age, departmentId);
                user.setId(id);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }
        return user;
    }

    @Override
    public List<User> getUsersOfDepartment(Integer departmentId) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        List<User> users;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();

            String sql = "SELECT id, name, age, departmentId FROM users " +
                    "WHERE departmentId="+ departmentId+" ORDER BY name";
            rs = stmt.executeQuery(sql);

            users = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                User user = new User(name, age, departmentId);
                user.setId(id);
                users.add(user);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }

          return users;
    }

    @Override
    public void addUser(User user) throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "INSERT INTO users(name, age, departmentId) VALUES(?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3, user.getDepartmentId());
            preparedStatement.executeUpdate();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "UPDATE users SET age=?, name=? WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void removeUser(Integer id) throws ClassNotFoundException, SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "DELETE FROM users WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
