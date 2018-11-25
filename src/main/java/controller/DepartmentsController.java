package controller;

import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DepartmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by dmitry on 12.03.18.
 */
@Controller
//@RequestMapping(value = "/mvc")
public class DepartmentsController {

    @Autowired
    private DepartmentService departmentService;
//    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentsDaoOracleImpl());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws SQLException, ClassNotFoundException {
        return "index";
    }

    @RequestMapping(value = "/mainServlet", method = RequestMethod.GET)
    public ModelAndView main() throws SQLException, ClassNotFoundException, CustomException {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("departmentsList", departmentService.getDepartments());
        modelAndView.setViewName("departments");
        return modelAndView;
    }

    @RequestMapping(value = "/addDepartmentServlet", method = RequestMethod.GET)
    public ModelAndView goToAddEditJsp(@RequestParam(required = false) Integer id) throws SQLException, ClassNotFoundException {
//        String paramId = req.getParameter("id");
        ModelAndView modelAndView = new ModelAndView();
        if (id != null) {
//            DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentsDaoMysqlImpl());
            Department department = null;
            try {
                department = departmentService.getDepartmentById(id);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            modelAndView.addObject(department);
//            modelAndView.addObject("editedName", department.getName());
//            modelAndView.addObject("id", id);
        } else {
            modelAndView.addObject(new Department());
        }
        modelAndView.setViewName("addEditDepartment");
        return modelAndView;
    }

    @RequestMapping(value = "/addDepartmentServlet", method = RequestMethod.POST)
    public void addDepartment(@ModelAttribute("department") Department department, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException {

        if (department.getId() == null) {
            departmentService.addDepartment(department);
        } else {
            departmentService.updateDepartment(department.getId(), department.getName());

        }

        response.sendRedirect("/mvc/mainServlet");
    }

    @RequestMapping(value = "/removeDepartmentServlet", method = RequestMethod.GET)
    public void removeDepartment(@RequestParam Integer id, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException {
         departmentService.removeDepartment(id);
        response.sendRedirect("/mvc/mainServlet");
    }
}
