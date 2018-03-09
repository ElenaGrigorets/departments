package servlets;

import dao.DepartmentDao;
import dao.impl.DepartmentsDaoMysqlImpl;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by dik81 on 23.01.18.
 */
@WebServlet (value = "/addDepartmentServlet")
public class AddEditDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String paramId = req.getParameter("id");
        if ( paramId != null ) {
            Integer id = Integer.valueOf(paramId);
            DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentsDaoMysqlImpl());
            Department department = null;
            try {
                department = departmentService.getDepartmentById(id);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("editedName", department.getName());
            req.setAttribute("id", id);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("addEditDepartment.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        String name = req.getParameter("name");
        if ( paramId==null||paramId.isEmpty()) {
            DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentsDaoMysqlImpl());
            Department department = new Department();
            department.setName(name);
            try {
                departmentService.addDepartment(department);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

//            Department department = new Department();
//            department.setName(name);
//            DepartmentsHolder.addDepartmentOldMethod(department);
            
        } else {
            Integer id = Integer.valueOf(paramId);
            DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentsDaoMysqlImpl());
            try {
                departmentService.updateDepartment(id, name);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

 /**
        req.setAttribute("departmentsList", DepartmentsHolder.getDepartments());
        RequestDispatcher dispatcher = req.getRequestDispatcher("departments.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/mainServlet");
  **/
        resp.sendRedirect("/mainServlet");
    }
}
