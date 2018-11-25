package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.User;

import java.util.List;

@RemoteServiceRelativePath("UsersServiceGWT")
public interface UsersServiceGWT extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    List<User> getUsersOfDepartment(Integer id);

    User getUserById(Integer id);

    void addUser(User user);

    void removeUser(Integer id);

    void updateUser(User user);

    /**
     * Utility/Convenience class.
     * Use MySampleApplicationService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static UsersServiceGWTAsync ourInstance = GWT.create(UsersServiceGWT.class);

        public static synchronized UsersServiceGWTAsync getInstance() {
            return ourInstance;
        }
    }
}
