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
                final FlexTable flexTable = new FlexTable();
                FlexTable.FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
                flexTable.setCellPadding(3);
                flexTable.setCellSpacing(5);
                for (int i = 0; i < result.size(); i++) {
                    final User userToAdd = result.get(i);
                    flexTable.setHTML(i, 1, String.valueOf(userToAdd.getId()));
                    flexTable.setHTML(i, 2, String.valueOf(userToAdd.getName()));
                    flexTable.setHTML(i, 3, String.valueOf(userToAdd.getAge()));
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
                    flexTable.setWidget(i, 4, removeButton);

                    Button editButton = new Button("Edit");
                    editButton.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            RootPanel.get().clear();
                            RootPanel.get().add(new UserAddEditFormPanel(userToAdd));
//                            UsersServiceGWT.App.getInstance().updateUser(userToAdd);
                        }
                    });
                    flexTable.setWidget(i, 5, editButton);
                }
                Button addButton = new Button("Add user");
                addButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        RootPanel.get().clear();
                        User user = new User();
                        user.setDepartmentId(departmentId);
                        RootPanel.get().add(new UserAddEditFormPanel(user));
                    }
                });
                Button backButton = new Button("Back to departments");
                backButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        RootPanel.get().clear();
                        RootPanel.get().add(new ListDepartmentsPanel());
                    }
                });
                VerticalPanel buttonPanel = new VerticalPanel();
                buttonPanel.setSpacing(6);
                buttonPanel.add(addButton);
                buttonPanel.add(backButton);
                int rc = flexTable.getRowCount();
                flexTable.setWidget(rc + 1, 1, buttonPanel);
                if (rc > 0) {
                    cellFormatter.setColSpan(rc + 1, 1, flexTable.getCellCount(rc - 1));
                }
                cellFormatter.setHorizontalAlignment(rc + 1, 1, HasHorizontalAlignment.ALIGN_CENTER);
                add(flexTable);
                RootPanel.get().clear();
                RootPanel.get().add(ListUsersPanel.this);
            }
        });

    }


}
