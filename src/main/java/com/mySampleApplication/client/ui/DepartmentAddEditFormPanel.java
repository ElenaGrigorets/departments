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
        FlexTable flexTable = new FlexTable();
        flexTable.setCellSpacing(6);
        FlexTable.FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
        flexTable.setHTML(1, 1, "Name: ");
        nameTextBox = new TextBox();
        nameTextBox.setValue(department.getName());
        flexTable.setWidget(1, 2, nameTextBox);

//        HorizontalPanel namePanel = new HorizontalPanel();
//        namePanel.add(new Label("Name: "));
//        nameTextBox.setValue(department.getName());
//        namePanel.add(nameTextBox);
//        setSize("50px", "50px");
//        add(namePanel);
        Button saveButton = new Button("Save");
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
        flexTable.setWidget(2, 2, saveButton);
        Button backButton = new Button("Back");
        cellFormatter.setHorizontalAlignment(4, 2, HasHorizontalAlignment.ALIGN_LEFT);
        backButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get().clear();
                RootPanel.get().add(new ListDepartmentsPanel());
            }
        });
        flexTable.setWidget(3, 2, backButton);
        RootPanel.get().clear();
        RootPanel.get().add(flexTable);

    }


}