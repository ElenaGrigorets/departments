package com.mySampleApplication.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.DepartmentsServiceGWT;
import com.mySampleApplication.client.UsersServiceGWT;
import com.mySampleApplication.client.shared.User;

/**
 * Created by dik81 on 07.09.18.
 */
public class UserAddEditFormPanel extends VerticalPanel {
    private TextBox nameTextBox;
    private IntegerBox ageBox;

    public UserAddEditFormPanel(final User user) {
        nameTextBox = new TextBox();
        HorizontalPanel namePanel = new HorizontalPanel();
        namePanel.add(new Label("Name: "));
        nameTextBox.setValue(user.getName());
        namePanel.add(nameTextBox);
        setSize("50px", "50px");
        add(namePanel);
        ageBox = new IntegerBox();
        HorizontalPanel agePanel = new HorizontalPanel();
        agePanel.add(new Label("Age: "));
        agePanel.add(ageBox);
        add(agePanel);

        Button saveButton = new Button("Save");
        namePanel.add(saveButton);
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                user.setName(nameTextBox.getValue());
                user.setAge(ageBox.getValue());
                if (user.getId() == null) {
                    UsersServiceGWT.App.getInstance().addUser(user,
                            new AsyncCallback<Void>() {
                                @Override
                                public void onFailure(Throwable caught) {
                                }

                                @Override
                                public void onSuccess(Void result) {
                                    new ListUsersPanel(user.getDepartmentId());
                                }
                            });
                } else {
                    UsersServiceGWT.App.getInstance().updateUser(user,
                            new AsyncCallback<Void>() {
                                @Override
                                public void onFailure(Throwable caught) {
                                }

                                @Override
                                public void onSuccess(Void result) {
                                    new ListUsersPanel(user.getDepartmentId());
                                }
                            });
                }

            }
        });

    }


}