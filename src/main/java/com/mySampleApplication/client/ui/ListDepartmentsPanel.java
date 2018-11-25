package com.mySampleApplication.client.ui;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.DepartmentsServiceGWT;
import com.mySampleApplication.client.UsersServiceGWT;
import com.mySampleApplication.client.shared.Department;
import com.mySampleApplication.client.shared.User;
import com.mySampleApplication.client.shared.exceptions.CustomException;

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
                if (caught instanceof CustomException) {
                    Window.alert("custome exception");
                }
            }

            @Override
            public void onSuccess(final List<Department> result) {
                final FlexTable flexTable = new FlexTable();
                FlexTable.FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
                flexTable.setCellPadding(3);
                flexTable.setCellSpacing(5);
                for (int i = 0; i < result.size(); i++) {
                    final Department departmentToAdd = result.get(i);
//                    HorizontalPanel horizontalPanel = new HorizontalPanel();


//                    flexTable.setHTML(i, 1, String.valueOf(departmentToAdd.getId()));
                    flexTable.setWidget(i, 2, createNameAnchor(departmentToAdd));

//                    horizontalPanel.add(new Label(String.valueOf(departmentToAdd.getId())));
//                    horizontalPanel.add(createNameAnchor(departmentToAdd));
                    Button removeButton = new Button("Remove");
                    removeButton.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            DepartmentsServiceGWT.App.getInstance().removeDepartment(departmentToAdd.getId(), new AsyncCallback<Void>() {
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
                    flexTable.setWidget(i, 3, removeButton);





                    Button editButton = new Button("Edit");
                    editButton.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            RootPanel.get().clear();
                            RootPanel.get().add(new DepartmentAddEditFormPanel(departmentToAdd));
                        }
                    });
                    flexTable.setWidget(i, 4, editButton);
                }

                Button addButton = new Button("Add department");
                addButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        RootPanel.get().clear();
                        RootPanel.get().add(new DepartmentAddEditFormPanel(new Department()));
                    }
                });
                int rc = flexTable.getRowCount();
                flexTable.setWidget(rc, 1, addButton);
                cellFormatter.setColSpan(rc, 1, flexTable.getCellCount(rc - 1));
                cellFormatter.setHorizontalAlignment(rc, 1, HasHorizontalAlignment.ALIGN_CENTER);

                Button showAllButton = new Button("Show all users");
                showAllButton.addClickHandler(new ClickHandler() {
                                                  @Override
                                                  public void onClick(ClickEvent event) {

                                                      FlexTable allFlexTable = new FlexTable();
                                                      FlexTable.CellFormatter cellFormatter1 = allFlexTable.getFlexCellFormatter();
                                                      allFlexTable.setCellSpacing(6);

                                                      for (int i = 0; i < result.size(); i++) {
                                                          final Department departmentToAdd = result.get(i);
                                                          allFlexTable.setHTML(i, 1, String.valueOf(departmentToAdd.getName() + ":"));
                                                          cellFormatter1.setVerticalAlignment(i, 1, ALIGN_TOP);
                                                          final FlexTable usersList = new FlexTable();
                                                          UsersServiceGWT.App.getInstance().getUsersOfDepartment(departmentToAdd.getId(),
                                                                  new AsyncCallback<List<User>>() {
                                                                      @Override
                                                                      public void onFailure(Throwable caught) {

                                                                      }

                                                                      @Override
                                                                      public void onSuccess(List<User> result) {
                                                                          for (int j = 0; j < result.size(); j++) {
                                                                              final User userToAdd = result.get(j);
                                                                              usersList.setHTML(j, 1, userToAdd.getName());
                                                                          }
                                                                      }
                                                                  });
                                                          allFlexTable.setWidget(i, 2, usersList);
                                                      }
                                                      Button backButton = new Button("Back");
                                                      HandlerRegistration handlerRegistration = backButton.addClickHandler(new ClickHandler() {
                                                          @Override
                                                          public void onClick(ClickEvent event) {
                                                              RootPanel.get().clear();
                                                              RootPanel.get().add(new ListDepartmentsPanel());
                                                          }
                                                      });
                                                      allFlexTable.setWidget(allFlexTable.getRowCount() + 1, 2, backButton);
                                                      RootPanel.get().clear();
                                                      RootPanel.get().add(allFlexTable);
                                                  }
                                              }

                );
                flexTable.setWidget(rc + 1, 1, showAllButton);
                cellFormatter.setColSpan(rc + 1, 1, flexTable.getCellCount(rc - 1));
                cellFormatter.setHorizontalAlignment(rc + 1, 1, HasHorizontalAlignment.ALIGN_CENTER);

//                private static class MyPopup extends PopupPanel{
//                    public MyPopup() {
//                        // PopupPanel's constructor takes 'auto-hide' as its boolean
//                        // parameter. If this is set, the panel closes itself
//                        // automatically when the user clicks outside of it.
//                        super(true);
//
//                        // PopupPanel is a SimplePanel, so you have to set it's widget
//                        // property to whatever you want its contents to be.
//                        setWidget(new Label("Click outside of this popup to close it"));
//                    }
//                }
//                }
                final DecoratedPopupPanel simplePopup = new DecoratedPopupPanel(true);
                final DecoratedPopupPanel picturePopup = new DecoratedPopupPanel(true);
                Button popupButton = new Button("Click to Popup", new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        // simplePopup.ensureDebugId("cwBasicPopup-simplePopup");
                        simplePopup.setWidth("200px");
                        simplePopup.setWidget(new HTML("This Is My First Popup"));
 //                       simplePopup.setWidget(new Label("Click outside of this popup to close it"));
                        //setWidget(new HTML("This is a first popup!"));
                        simplePopup.center();
                        simplePopup.show();
                    }
                });
                // Create a button to show the popup
                Button openButton = new Button("Show button", new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        // Reposition the popup relative to the button
                        Widget source = (Widget) event.getSource();
                        int left = source.getAbsoluteLeft() + 10;
                        int top = source.getAbsoluteTop() + 10;
//                        Image myImage = new Image()
//                        picturePopup.setWidget(new );
                        picturePopup.setPopupPosition(left, top);

                        // Show the popup
                        simplePopup.show();
                    }
                });

                flexTable.setWidget(rc + 2, 1, popupButton);
                flexTable.setWidget(rc + 2, 2, openButton);
                cellFormatter.setColSpan(rc + 2, 1, flexTable.getCellCount(rc - 1));
                cellFormatter.setHorizontalAlignment(rc + 2, 1, HasHorizontalAlignment.ALIGN_CENTER);

                add(flexTable);

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
                RootPanel.get().clear();
                RootPanel.get().add(new ListUsersPanel(departmentToAdd.getId()));
            }
        });
        return anchor;
    }
}
