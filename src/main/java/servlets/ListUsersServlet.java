package servlets;

import dao.impl.DepartmentsDaoMysqlImpl;
import dao.impl.UserDaoMysqlImpl;
import model.Department;
import service.DepartmentService;
import service.UserService;
import service.impl.DepartmentServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by dik81 on 25.01.18.
 */
@WebServlet (value = "/listUsersServlet")
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentsDaoMysqlImpl());
        UserService userService = new UserServiceImpl(new UserDaoMysqlImpl());
        try {
            Department department = departmentService.getDepartmentById(id);
            req.setAttribute("usersList", userService.getUsersOfDepartment(id));
            req.setAttribute("departmentName", department.getName());
            req.setAttribute("departmentId", id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("users.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
