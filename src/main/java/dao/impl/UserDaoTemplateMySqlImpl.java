package dao.impl;

import dao.UserDao;
import com.mySampleApplication.client.shared.User;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.SQLException;
import java.util.List;


public class UserDaoTemplateMySqlImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private UserDaoTemplateMySqlImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public User getUserById(Integer id) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM users WHERE id=?";
        return jdbcTemplate.queryForObject(SQL, new UserMapper(), id);
    }

    @Override
    public List<User> getUsersOfDepartment(Integer id) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM users WHERE departmentId=? ORDER BY name";
        return jdbcTemplate.query(SQL, new UserMapper(), id);
    }

    @Override
    public void addUser(User user) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO users(name, age, departmentId) VALUES(?,?,?)";
        jdbcTemplate.update(SQL, user.getName(), user.getAge(), user.getDepartmentId());
    }

    @Override
    public void updateUser(Integer id, String name, Integer age) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE users SET age=?, name=? WHERE id=?";
        jdbcTemplate.update(SQL, age, name, id);
    }

    @Override
    public void removeUser(Integer id) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
 }

