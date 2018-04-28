package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.DepartmentsServiceGWT;
import service.DepartmentService;

/**
 * Created by dik81 on 28.04.18.
 */
public class DepartmentsServiceGWTImpl extends RemoteServiceServlet implements DepartmentsServiceGWT {
    @Override
    public String getMessage(String msg) {
        return "test string";
    }
}
