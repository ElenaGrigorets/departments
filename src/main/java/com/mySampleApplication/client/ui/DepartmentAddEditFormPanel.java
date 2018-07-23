package com.mySampleApplication.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.DepartmentsServiceGWT;
import com.mySampleApplication.client.shared.Department;

import java.util.List;

/**
 * Created by dik81 on 28.04.18.
 */
public class DepartmentAddEditFormPanel extends VerticalPanel {
    private TextBox nameTextBox;

    public DepartmentAddEditFormPanel(final Department department) {
        nameTextBox = new TextBox();
        HorizontalPanel namePanel = new HorizontalPanel();
        namePanel.add(new Label("Name: "));
        nameTextBox.setValue(department.getName());
        namePanel.add(nameTextBox);
        setSize("50px", "50px");
        add(namePanel);
        Button saveButton = new Button("Save");
        namePanel.add(saveButton);
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                department.setName(nameTextBox.getValue());
                if (department.getId() == null) {
                    DepartmentsServiceGWT.App.getInstance().addDepartment(department,
                            new AsyncCallback<Void>() {
                                @Override
                                public void onFailure(Throwable caught) {
                                }

                                @Override
                                public void onSuccess(Void result) {
                                    new ListDepartmentsPanel();
                                }
                            });
                } else {
                    DepartmentsServiceGWT.App.getInstance().updateDepartment(department,
                            new AsyncCallback<Void>() {
                                @Override
                                public void onFailure(Throwable caught) {
                                }

                                @Override
                                public void onSuccess(Void result) {
                                    new ListDepartmentsPanel();
                                }
                            });
                }

            }
        });

    }


}