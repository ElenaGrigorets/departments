package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface DepartmentsServiceGWTAsync {
    // Sample interface method of remote interface
    void getMessage(String msg, AsyncCallback<String> async);
}
