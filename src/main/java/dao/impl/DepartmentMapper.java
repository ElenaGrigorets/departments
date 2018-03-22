package dao.impl;

import model.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentMapper implements RowMapper<Department> {
  @Override
  public Department mapRow(ResultSet resultSet, int i) throws SQLException {

    Department department = new Department();
    department.setId(resultSet.getInt("id"));
    department.setName(resultSet.getString("name"));
    return department;
  }
}