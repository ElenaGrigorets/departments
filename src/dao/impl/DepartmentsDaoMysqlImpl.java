package dao.impl;

import dao.DepartmentDao;
import model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dik81 on 30.01.18.
 */
public class DepartmentsDaoMysqlImpl implements DepartmentDao {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/departments";
    Connection conn = null;
    Statement stmt = null;

    @Override
    public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, "root", "root");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, name FROM departments";
        ResultSet rs = stmt.executeQuery(sql);

        //STEP 5: Extract data from result set
        List<Department> departments = new ArrayList<>();
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            Department department = new Department();
            department.setId(id);
            department.setName(name);
            departments.add(department);
        }
        //STEP 6: Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
        return departments;
    }
}
