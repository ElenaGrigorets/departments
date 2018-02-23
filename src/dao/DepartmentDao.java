package dao;

import model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dik81 on 30.01.18.
 */
public interface DepartmentDao {

    Department getDepartmentById(Integer id) throws ClassNotFoundException, SQLException;

    Department getDepartmentByIdPreparedStatement(Integer departmentId) throws ClassNotFoundException, SQLException;

    List<Department> getDepartments() throws ClassNotFoundException, SQLException;

    void addDepartmentOldMethod(Department department) throws ClassNotFoundException, SQLException;
    void addDepartment(Department department) throws ClassNotFoundException, SQLException;

    void removeDepartment(Integer id) throws ClassNotFoundException, SQLException;

    void updateDepartment(Integer id, String name) throws ClassNotFoundException, SQLException;
}
