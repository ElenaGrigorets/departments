package controller;

import com.mySampleApplication.client.shared.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DepartmentService;
import service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by dik81 on 20.03.18.
 */
@Controller
//@RequestMapping(value = "/mvc")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/listUsersServlet", method = RequestMethod.GET)
    public ModelAndView listOfUsers(@RequestParam Integer id) throws SQLException, ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList", userService.getUsersOfDepartment(id));
        modelAndView.addObject("department", departmentService.getDepartmentById(id));
        modelAndView.setViewName("users");
        return modelAndView;
    }
    @RequestMapping(value = "/addUserServlet", method = RequestMethod.GET)
    public ModelAndView goToAddEditUser(@RequestParam(required = false) Integer userId, Integer id) throws SQLException, ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        if (userId != null){
            User user = null;
              try {
                  user = userService.getUserById(userId);
              }catch (SQLException |ClassNotFoundException e) {
                  e.printStackTrace();
              }
            modelAndView.addObject(user);
        }else {
            modelAndView.addObject(new User());
        }
        modelAndView.addObject("departmentId", departmentService.getDepartmentById(id).getId());
        modelAndView.setViewName("addEditUser");
        return modelAndView;
    }
    @RequestMapping(value = "/addUserServlet", method = RequestMethod.POST)
    public void addUser(@ModelAttribute("user") User user, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        if (user.getId()==null) {
            userService.addUser(user);
        }else {
            userService.updateUser(user.getId(), user.getName(), user.getAge());
        }
        response.sendRedirect("/mvc/listUsersServlet?id=" + user.getDepartmentId());
    }

    @RequestMapping(value = "/removeUserServlet", method = RequestMethod.GET)
    public void removeUser(@RequestParam Integer userId, Integer id, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        userService.removeUser(userId);
        response.sendRedirect("/mvc/listUsersServlet?id=" + id);
    }
}
