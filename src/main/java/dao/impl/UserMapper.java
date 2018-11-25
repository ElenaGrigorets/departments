package dao.impl;

import com.mySampleApplication.client.shared.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dik81 on 22.03.18.
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setDepartmentId(resultSet.getInt("departmentId"));
        return user;
    }
}
