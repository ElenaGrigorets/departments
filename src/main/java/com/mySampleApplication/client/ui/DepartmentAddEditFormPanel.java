package com.mySampleApplication.client.ui;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mySampleApplication.shared.Department;

/**
 * Created by dik81 on 28.04.18.
 */
public class DepartmentAddEditFormPanel extends VerticalPanel {
    private TextBox nameTextBox;

    public DepartmentAddEditFormPanel(Department department) {
        nameTextBox = new TextBox();
        HorizontalPanel namePanel = new HorizontalPanel();
        namePanel.add(new Label("Name: "));
        nameTextBox.setValue(department.getName());
        namePanel.add(nameTextBox);
        setSize("400px", "400px");
        add(namePanel);
    }
}
