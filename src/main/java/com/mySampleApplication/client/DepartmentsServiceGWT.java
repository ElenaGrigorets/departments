package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mySampleApplication.client.shared.Department;

import java.util.List;

@RemoteServiceRelativePath("DepartmentsServiceGWT")
public interface DepartmentsServiceGWT extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    List<Department> getDepartments();

    /**
     * Utility/Convenience class.
     * Use MySampleApplicationService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static DepartmentsServiceGWTAsync ourInstance = GWT.create(DepartmentsServiceGWT.class);

        public static synchronized DepartmentsServiceGWTAsync getInstance() {
            return ourInstance;
        }
    }
}
