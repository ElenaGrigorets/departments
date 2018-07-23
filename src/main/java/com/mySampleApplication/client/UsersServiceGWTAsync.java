package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mySampleApplication.client.shared.Department;
import model.User;

import java.util.List;

public interface UsersServiceGWTAsync {
    // Sample interface method of remote interface
    void getMessage(String msg, AsyncCallback<String> async);

    void getDepartments(AsyncCallback<List<Department>> async);

    void addDepartment(Department department, AsyncCallback<Void> async);

    void removeDepartment(Integer id, AsyncCallback<Void> async);

    void updateDepartment(Department department, AsyncCallback<Void> async);

    void getUsersOfDepartment(Integer id, AsyncCallback<List<User>> async);
}
