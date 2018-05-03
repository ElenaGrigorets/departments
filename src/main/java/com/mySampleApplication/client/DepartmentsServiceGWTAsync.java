package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mySampleApplication.client.shared.Department;

import java.util.List;

public interface DepartmentsServiceGWTAsync {
    // Sample interface method of remote interface
    void getMessage(String msg, AsyncCallback<String> async);

    void getDepartments(AsyncCallback<List<Department>> callback);
}
