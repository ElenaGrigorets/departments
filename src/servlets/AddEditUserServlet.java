package servlets;

import holder.DepartmentsHolder;
import model.Department;
import model.User;

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
@WebServlet (value ="/addUserServlet")
public class AddEditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Integer.valueOf(req.getParameter("userId"));
        Integer id = Integer.valueOf(req.getParameter("id"));
        Department department = DepartmentsHolder.getDepartmentById(id);
        User user = department.getUserById(userId);
        req.setAttribute("editedName", user.getName());
        req.setAttribute("editedAge", user.getAge());
        req.setAttribute("id", id);
        req.setAttribute("userId", userId);
        req.getRequestDispatcher("addEditUser.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Integer departmentId = Integer.valueOf(req.getParameter("id"));
        Department department = DepartmentsHolder.getDepartmentById(departmentId);
        String paramUserId = req.getParameter("userId");
        if (paramUserId==null||paramUserId.isEmpty()) {
            User user = new User(name, age);
            department.addUser(user);
        } else {
            Integer userId = Integer.valueOf(paramUserId);
            User user = department.getUserById(userId);
            user.setName(name);
            user.setAge(age);
        }
        req.setAttribute("departmentName", department.getName());
        req.setAttribute("departmentId", departmentId);
        req.setAttribute("usersList", department.getUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("users.jsp");
        dispatcher.forward(req, resp);
    }
}
