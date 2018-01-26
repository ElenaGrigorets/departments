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
@WebServlet (value = "/removeUserServlet")
public class RemoveUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Integer.valueOf(req.getParameter("userId"));
        Integer departmentId = Integer.valueOf(req.getParameter("id"));
        Department department = DepartmentsHolder.getDepartmentById(departmentId);
        department.removeUser(userId);
        req.setAttribute("id", departmentId);
        req.getRequestDispatcher("/listUsersServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
