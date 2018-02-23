package servlets;

import dao.DepartmentDao;
import dao.impl.DepartmentsDaoMysqlImpl;

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
@WebServlet (value = "/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      req.setAttribute("departmentsList", DepartmentsHolder.getDepartments());
        DepartmentDao departmentDao = new DepartmentsDaoMysqlImpl();
        try {
            req.setAttribute("departmentsList", departmentDao.getDepartments());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("departments.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
