package service;

import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.exceptions.CustomException;

import java.sql.SQLException;
import java.util.List;



public interface DepartmentService {
    Department getDepartmentById(Integer departmentId) throws SQLException, ClassNotFoundException;

    List<Department> getDepartments() throws SQLException, ClassNotFoundException, CustomException;
   
    void addDepartment(Department department) throws SQLException, ClassNotFoundException;

    void removeDepartment(Integer id) throws SQLException, ClassNotFoundException;

    void updateDepartment(Integer id, String name) throws SQLException, ClassNotFoundException;
}
