package com.mySampleApplication.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.DepartmentsServiceGWT;
import com.mySampleApplication.client.shared.Department;

import java.util.List;

/**
 * Created by dik81 on 02.07.18.
 */
public class ListDepartmentsPanel extends VerticalPanel {



    public ListDepartmentsPanel() {
        DepartmentsServiceGWT.App.getInstance().getDepartments(new AsyncCallback<List<Department>>() {
            @Override
            public void onFailure(Throwable caught) {
                System.out.println("oops!..fail...");
            }

            @Override
            public void onSuccess(List<Department> result) {
                for (final Department departmentToAdd : result) {
                    HorizontalPanel horizontalPanel = new HorizontalPanel();
                    horizontalPanel.add(new Label(String.valueOf(departmentToAdd.getId())));
                    horizontalPanel.add(createNameAnchor(departmentToAdd));
                    Button removeButton = new Button("Remove");
                    removeButton.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            DepartmentsServiceGWT.App.getInstance().removeDepartment(departmentToAdd.getId(),
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
                    });
                    horizontalPanel.add(removeButton);

                    add(horizontalPanel);
                }


                Button addButton = new Button("Add department");
                addButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        RootPanel.get().clear();
                        RootPanel.get().add(new DepartmentAddEditFormPanel(new Department()));
                    }
                });
                add(addButton);
                RootPanel.get().clear();
                RootPanel.get().add(ListDepartmentsPanel.this);
            }
        });

    }

    private Anchor createNameAnchor(final Department departmentToAdd) {
        final Anchor anchor = new Anchor(departmentToAdd.getName());
//        anchor.addClickListener(new ClickListener() {
//            @Override
//            public void onClick(Widget sender) {
//                anchor.getElement().getStyle().setColor("red");
//                String s = "fdfd";
//            }
//        });
        anchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                DepartmentsServiceGWT.App.getInstance().getMessage(departmentToAdd.getName(),
                        new AsyncCallback<String>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                Window.alert("bad");
                            }

                            @Override
                            public void onSuccess(String result) {
                                RootPanel.get().clear();
                                RootPanel.get().add(new DepartmentAddEditFormPanel(departmentToAdd));
                            }
                        });

            }
        });
        return anchor;
    }

//    anchor.addClickHandler(new ClickHandler() {
//        @Override
//        public void onClick(ClickEvent event) {
//            DepartmentsServiceGWT.App.getInstance().getMessage(departmentToAdd.getName(),
//                    new AsyncCallback<String>() {
//                        @Override
//                        public void onFailure(Throwable caught) {
//                            Window.alert("bad");
//                        }
//
//                        @Override
//                        public void onSuccess(String result) {
//                            RootPanel.get().clear();
//                            RootPanel.get().add(new DepartmentAddEditFormPanel(departmentToAdd));
//                        }
//                    });
//
//        }
//    });
}
