package dao;

import model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dik81 on 30.01.18.
 */
public interface DepartmentDao {
    List<Department> getDepartments() throws ClassNotFoundException, SQLException;
}
