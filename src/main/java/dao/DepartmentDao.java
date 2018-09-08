package dao;

import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.exceptions.CustomException;

import java.sql.SQLException;
import java.util.List;


public interface DepartmentDao {

//  Department getDepartmentByIdOldMethod(Integer id) throws ClassNotFoundException, SQLException;

    Department getDepartmentById(Integer departmentId) throws ClassNotFoundException, SQLException;

    List<Department> getDepartments() throws ClassNotFoundException, SQLException, CustomException;

//  void addDepartmentOldMethod(Department department) throws ClassNotFoundException, SQLException;

    void addDepartment(Department department) throws ClassNotFoundException, SQLException;

    void removeDepartment(Integer id) throws ClassNotFoundException, SQLException;

    void updateDepartment(Integer id, String name) throws ClassNotFoundException, SQLException;
}
