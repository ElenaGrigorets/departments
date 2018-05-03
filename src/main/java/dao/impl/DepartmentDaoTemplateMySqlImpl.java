package dao.impl;

import dao.DepartmentDao;
import com.mySampleApplication.client.shared.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dik81 on 22.03.18.
 */
//@Repository
public class DepartmentDaoTemplateMySqlImpl implements DepartmentDao {
//    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DepartmentDaoTemplateMySqlImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Department getDepartmentById(Integer departmentId) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT id, name FROM departments where id = ?";
        Department department = jdbcTemplate.queryForObject(SQL,new DepartmentMapper(), departmentId);
        return department;
    }

    @Override
    public List<Department> getDepartments() throws ClassNotFoundException, SQLException {

//        List<Map<String, Object>> departments = jdbcTemplate.queryForList("SELECT id, name FROM departments ORDER BY name");
//        List<Department> departmentList = new ArrayList<>();
//        for (Map<String, Object> departmentObject : departments) {
//            Department department = new Department();
//            department.setId(Integer.parseInt(String.valueOf(departmentObject.get("id"))));
//            department.setName(String.valueOf(departmentObject.get("name")));
//            departmentList.add(department);
//        }
//        return departmentList;
//    }

        String SQL = "SELECT id, name FROM departments ORDER BY name";
        return jdbcTemplate.query(SQL, new DepartmentMapper());
    }

    @Override
    public void addDepartment(Department department) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO departments(name) VALUES(?)";
        jdbcTemplate.update(SQL, department.getName());
    }

    @Override
    public void removeDepartment(Integer id) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM departments WHERE id=?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updateDepartment(Integer id, String name) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE departments SET name=? WHERE id=?";
        jdbcTemplate.update(SQL, name, id);
    }
}
