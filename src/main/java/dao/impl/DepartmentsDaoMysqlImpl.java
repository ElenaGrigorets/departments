package dao.impl;

import dao.DepartmentDao;
import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentsDaoMysqlImpl implements DepartmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/departments";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement prst = null;

     static {
         try {
             Class.forName(JDBC_DRIVER);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }

    public DepartmentsDaoMysqlImpl() {
    }

    @Override
    public Department getDepartmentByIdOldMethod(Integer departmentId) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        Department department = null;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();

            String sql = "SELECT id, name FROM departments where id = " + departmentId;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                return department;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }
        return department;
    }



    @Override
    public Department getDepartmentById(Integer departmentId) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        Department department = null;
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();

            String sql = "SELECT id, name FROM departments where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement("" + sql);

            preparedStatement.setInt(1, departmentId);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                return department;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }
        return department;
    }

    @Override
    public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
        List<Map<String, Object>> departments = jdbcTemplate.queryForList("SELECT id, name FROM departments ORDER BY name");
        List<Department> departmentList = new ArrayList<>();
        for (Map<String, Object> departmentObject : departments) {
            Department department = new Department();
            department.setId(Integer.parseInt(String.valueOf(departmentObject.get("id"))));
            department.setName(String.valueOf(departmentObject.get("name")));
            departmentList.add(department);
        }
        return departmentList;
//        https://www.jeejava.com/select-example-using-spring-jdbctemplate/
//        ResultSet rs = null;
//        List<Department> departments;
//        try {
//            conn = DriverManager.getConnection(DB_URL, "root", "root");
//            stmt = conn.createStatement();
//
//            String sql = "SELECT id, name FROM departments ORDER BY name";
//            rs = stmt.executeQuery(sql);
//
//            departments = new ArrayList<>();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                Department department = new Department();
//                department.setId(id);
//                department.setName(name);
//                departments.add(department);
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            stmt.close();
//        }
//        return departments;
    }

    @Override
    public void addDepartmentOldMethod(Department department) throws ClassNotFoundException, SQLException {
        int id = 0;
        String name = department.getName();
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();

            String sqlGetId = "SELECT id FROM departments";
            rs = stmt.executeQuery(sqlGetId);

            while (rs.next()){
                int sqlId = rs.getInt("id");
                id = sqlId + 1;
            }
        }finally {
            if (rs != null) {
                rs.close();
            }
            stmt.close();
        }
        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");
            stmt = conn.createStatement();
            String sql = "INSERT INTO departments VALUES";
            stmt.executeUpdate(sql+"("+id+",\'"+name+"\')");
        }finally {
            stmt.close();
        }

    }
    @Override
    public void addDepartment(Department department) throws ClassNotFoundException, SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "INSERT INTO departments(name) VALUES(?)";
            prst = conn.prepareStatement(sql);
            prst.setString(1, department.getName());
            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }
    }

    @Override
    public void removeDepartment(Integer id) throws ClassNotFoundException, SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "DELETE FROM departments WHERE id = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1, id);
            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }

    }

    @Override
    public void updateDepartment(Integer id, String name) throws ClassNotFoundException, SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, "root", "root");

            String sql = "UPDATE departments SET name=? WHERE id=?";
            prst = conn.prepareStatement(sql);
            prst.setInt(2, id);
            prst.setString(1, name);
            prst.executeUpdate();

        } finally {
            if (prst != null) {
                prst.close();
            }
        }
    }
}

