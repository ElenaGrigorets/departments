package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.User;

import java.util.List;

public interface UsersServiceGWTAsync {
    // Sample interface method of remote interface
    void getMessage(String msg, AsyncCallback<String> async);

    void getUsersOfDepartment(Integer id, AsyncCallback<List<User>> async);

    void getUserById(Integer id, AsyncCallback<User> async);

    void addUser(User user, AsyncCallback<Void> async);

    void removeUser(Integer id, AsyncCallback<Void> async);

    void updateUser(User user, AsyncCallback<Void> async);

}
