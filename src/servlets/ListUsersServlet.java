package servlets;

import holder.DepartmentsHolder;
import model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dik81 on 25.01.18.
 */
@WebServlet (value = "/listUsersServlet")
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Department department = DepartmentsHolder.getDepartmentById(id);
        req.setAttribute("usersList", department.getUsers());
        req.setAttribute("departmentName", department.getName());
        req.setAttribute("departmentId", id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("users.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
