package com.mySampleApplication.client.shared;

import holder.DepartmentsHolder;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dik81 on 23.01.18. ResultSet rs = null;
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
 */
public class Department implements Serializable {
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    private Map<Integer, User> userMap = new HashMap<>();

//    public void addUser(User user) {
//        user.setId(DepartmentsHolder.createId(userMap.keySet()));
//        userMap.put(user.getId(), user);
//    }

//    public Collection<User> getUsersOfDepartment() { return userMap.values();   }
//    public void removeUser(Integer id) { userMap.remove(id);   }
//
//    public User getUserById(Integer id) { return userMap.get(id);  }

//    @Override
//    public int compareTo(Department o) {
//        return this.name.compareTo(o.getName());
//    }
}
