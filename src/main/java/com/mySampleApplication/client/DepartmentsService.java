package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("DepartmentsService")
public interface DepartmentsService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use MySampleApplicationService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static DepartmentsServiceAsync ourInstance = GWT.create(DepartmentsService.class);

        public static synchronized DepartmentsServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
