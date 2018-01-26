package servlets;

import holder.DepartmentsHolder;
import model.Department;
import sun.invoke.empty.Empty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            Department department = DepartmentsHolder.getDepartmentById(id);
            req.setAttribute("editedName", department.getName());
            req.setAttribute("id", id);
        } else {

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("addEditDepartment.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        String name = req.getParameter("name");
        if ( paramId==null||paramId.isEmpty()) {
            Department department = new Department();
            department.setName(name);
            DepartmentsHolder.addDepartment(department);
        } else {
            Integer id = Integer.valueOf(paramId);
            DepartmentsHolder.getDepartmentById(id).setName(name);
        }

 /**
        req.setAttribute("departmentsList", DepartmentsHolder.getDepartments());
        RequestDispatcher dispatcher = req.getRequestDispatcher("departments.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/mainServlet");
  **/
        resp.sendRedirect("/mainServlet");
    }
}
