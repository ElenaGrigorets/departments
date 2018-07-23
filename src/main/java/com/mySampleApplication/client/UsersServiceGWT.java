package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mySampleApplication.client.shared.Department;
import model.User;

import java.util.List;

@RemoteServiceRelativePath("UsersServiceGWT")
public interface UsersServiceGWT extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    List<Department> getDepartments();

    List<User> getUsersOfDepartment(Integer id);

    void addDepartment(Department department);

    void removeDepartment(Integer id);

    void updateDepartment(Department department);

    /**
     * Utility/Convenience class.
     * Use MySampleApplicationService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static DepartmentsServiceGWTAsync ourInstance = GWT.create(UsersServiceGWT.class);

        public static synchronized DepartmentsServiceGWTAsync getInstance() {
            return ourInstance;
        }
    }
}
