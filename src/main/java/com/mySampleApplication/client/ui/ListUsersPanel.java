package com.mySampleApplication.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.DepartmentsServiceGWT;
import com.mySampleApplication.client.UsersServiceGWT;
import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.User;

import java.util.List;

/**
 * Created by dik81 on 02.07.18.
 */
public class ListUsersPanel extends VerticalPanel {

    public ListUsersPanel(final Integer departmentId) {
        UsersServiceGWT.App.getInstance().getUsersOfDepartment(departmentId, new AsyncCallback<List<User>>() {
            @Override
            public void onFailure(Throwable caught) {
                System.out.println("oops!..fail...");
            }

            @Override
            public void onSuccess(List<User> result) {

                for (final User userToAdd : result) {
                    HorizontalPanel horizontalPanel = new HorizontalPanel();
                    horizontalPanel.add(new Label(String.valueOf(userToAdd.getId())));
                    horizontalPanel.add(new Label(String.valueOf(userToAdd.getName())));

                    Button removeButton = new Button("Remove");
                    removeButton.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            UsersServiceGWT.App.getInstance().removeUser(userToAdd.getId(),
                                    new AsyncCallback<Void>() {
                                        @Override
                                        public void onFailure(Throwable caught) {
                                        }

                                        @Override
                                        public void onSuccess(Void result) {
                                            new ListUsersPanel(departmentId);
                                        }
                                    });
                        }
                    });
                    horizontalPanel.add(removeButton);
                    add(horizontalPanel);
                    Button editButton = new Button("Edit");
                    editButton.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            RootPanel.get().clear();
                            RootPanel.get().add(new UserAddEditFormPanel(userToAdd));
//                            UsersServiceGWT.App.getInstance().updateUser(userToAdd);
                        }
                    });
                }
                Button addButton = new Button("Add user");
                addButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        RootPanel.get().clear();
                        RootPanel.get().add(new DepartmentAddEditFormPanel(new Department()));
                    }
                });
                add(addButton);
                RootPanel.get().clear();
                RootPanel.get().add(ListUsersPanel.this);
            }
        });

    }


}
