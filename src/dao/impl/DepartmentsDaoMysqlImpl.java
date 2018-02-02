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
    static Connection conn = null;
    static Statement stmt = null;

     static {
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }

    @Override
    public Department getDepartmentById(Integer id) throws ClassNotFoundException, SQLException {

       //todo create this method

        /**
         * //todoCREATE THIS METHOD!!!!
         * */

            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();

        String sql = "SELECT id, name FROM departments where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement("" +
                sql);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Department department = null;
        while (resultSet.next()) {
            department = new Department();
            department.setId(resultSet.getInt("id"));
            department.setName(resultSet.getString("name"));
            return department;
        }
        return null;
    }

    @Override
    public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
        conn = DriverManager.getConnection(DB_URL, "root", "root");
        stmt = conn.createStatement();

        String sql;
        sql = "SELECT id, name FROM departments";
        ResultSet rs = stmt.executeQuery(sql);

        //Extract data from result set
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


        //Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
        return departments;
    }
}
