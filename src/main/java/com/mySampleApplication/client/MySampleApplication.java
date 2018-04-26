package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.i18n.shared.AnyRtlDirectionEstimator;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        // Create a FormPanel and point it at a service.
        final FormPanel form = new FormPanel();
        form.setAction("/myFormHandler");

        // Because we're going to add a FileUpload widget,
        // we'll need to set the form to use the POST method,
        // and multipart MIME encoding.
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        // Create a panel to hold all of the form widgets.
        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        form.setWidget(panel);

        // Create a TextBox, giving it a name so that it will be submitted.
        final TextBox tb = new TextBox();
        tb.setWidth("220");

        tb.setName("textBoxFormElement");
        panel.add(tb);

        // Create a ListBox, giving it a name and
        // some values to be associated with its options.
        ListBox lb = new ListBox();
        lb.setName("listBoxFormElement");
        lb.addItem("item1", "item1");
        lb.addItem("item2", "item2");
        lb.addItem("item3", "item3");
        lb.setWidth("220");
        panel.add(lb);

        // Create a FileUpload widget.
        FileUpload upload = new FileUpload();
        upload.setName("uploadFormElement");
        panel.add(upload);

        // Add a 'submit' button.
        panel.add(new Button("Submit", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                form.submit();
            }
        }));

        // Add an event handler to the form.
        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent event) {
                // This event is fired just before the form is submitted.
                // We can take this opportunity to perform validation.
                if (tb.getText().length() == 0) {
                    Window.alert("The text box must not be empty");
                    event.cancel();
                }
            }
        });

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                // When the form submission is successfully completed,
                // this event is fired. Assuming the service returned
                // a response of type text/html, we can get the result
                // here.
                Window.alert(event.getResults());
            }
        });

        DecoratorPanel decoratorPanel = new DecoratorPanel();
        decoratorPanel.add(form);
        // Add the widgets to the root panel.
        RootPanel.get().add(decoratorPanel);
    }


    /**
     * Create a TextBox example that includes the text box and an optional handler
     * that updates a Label with the currently selected text.
     *
     * @param textBox the text box to handle
     * @param addSelection add handlers to update label
     * @return the Label that will be updated
     */
    private HorizontalPanel createTextExample(
            final TextBoxBase textBox, boolean addSelection) {
        // Add the text box and label to a panel
        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setSpacing(4);
        hPanel.add(textBox);

        // Add handlers
        if (addSelection) {
            // Create the new label
            final Label label = new Label("dfdfdf" + ": 0, 0");

            // Add a KeyUpHandler
            textBox.addKeyUpHandler(new KeyUpHandler() {
                public void onKeyUp(KeyUpEvent event) {
                    updateSelectionLabel(textBox, label);
                }
            });

            // Add a ClickHandler
            textBox.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    updateSelectionLabel(textBox, label);
                }
            });

            // Add the label to the box
            hPanel.add(label);
        }

        // Return the panel
        return hPanel;
    }

    /**
     * Update the text in one of the selection labels.
     *
     * @param textBox the text box
     * @param label the label to update
     */
    private void updateSelectionLabel(TextBoxBase textBox, Label label) {
        label.setText(
                "rrrr" + ": " + textBox.getCursorPos() + ", "
                        + textBox.getSelectionLength());
    }


    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
