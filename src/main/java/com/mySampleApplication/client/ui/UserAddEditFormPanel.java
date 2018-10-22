package com.mySampleApplication.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Constants;
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
        FlexTable flexTable = new FlexTable();
        flexTable.setCellSpacing(6);
        FlexTable.FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
        flexTable.setHTML(1, 1, "Name: ");
        flexTable.setHTML(2, 1, "Age: ");
        nameTextBox = new TextBox();
        ageBox = new IntegerBox();
        nameTextBox.setValue(user.getName());
        ageBox.setValue(user.getAge());
        flexTable.setWidget(1, 2, nameTextBox);
        flexTable.setWidget(2, 2, ageBox);
//
//        HorizontalPanel namePanel = new HorizontalPanel();
//        namePanel.add(new Label("Name: "));
//        nameTextBox.setValue(user.getName());
//        namePanel.add(nameTextBox);
//        setSize("50px", "50px");
//        add(namePanel);
//
//        HorizontalPanel agePanel = new HorizontalPanel();
//        agePanel.add(new Label("Age: "));
//        agePanel.add(ageBox);
//        add(agePanel);

        Button saveButton = new Button("Save");
//        cellFormatter.setColSpan(3, 1, 2);
        cellFormatter.setHorizontalAlignment(3, 2, HasHorizontalAlignment.ALIGN_LEFT);
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
        flexTable.setWidget(3, 2, saveButton);
        Button backButton = new Button("Back");
//        cellFormatter.setColSpan(4, 1, 2);
        cellFormatter.setHorizontalAlignment(4, 2, HasHorizontalAlignment.ALIGN_LEFT);
        backButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get().clear();
                RootPanel.get().add(new ListUsersPanel(user.getDepartmentId()));
            }
        });
        flexTable.setWidget(4, 2, backButton);
        DecoratorPanel decPanel = new DecoratorPanel();
        decPanel.setWidget(flexTable);

        RootPanel.get().clear();
        RootPanel.get().add(decPanel);
    }

}