package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.DepartmentsServiceGWT;
import com.mySampleApplication.client.shared.Department;
import dao.DepartmentDao;
import dao.impl.DepartmentsDaoMysqlImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dik81 on 28.04.18.
 */
public class DepartmentsServiceGWTImpl extends RemoteServiceServlet implements DepartmentsServiceGWT {
    @Override
    public String getMessage(String msg) {
        return "test string";
    }

    @Override
    public List<Department> getDepartments() {
        DepartmentDao departmentDao = new DepartmentsDaoMysqlImpl();
        try {
            return departmentDao.getDepartments();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addDepartment(Department department) {
        DepartmentDao departmentDao = new DepartmentsDaoMysqlImpl();
        try {
            departmentDao.addDepartment(department);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDepartment(Integer id) {
        DepartmentDao departmentDao = new DepartmentsDaoMysqlImpl();
        try {
            departmentDao.removeDepartment(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDepartment(Department department){
        DepartmentDao departmentDao = new DepartmentsDaoMysqlImpl();
        try {
            departmentDao.updateDepartment( department.getId(), department.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
