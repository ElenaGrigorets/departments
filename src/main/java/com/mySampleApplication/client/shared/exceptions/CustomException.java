package com.mySampleApplication.client.shared.exceptions;

import java.io.Serializable;

public class CustomException extends Exception implements Serializable {

    private String customString;

    public CustomException(String message, String customString) {
        super(message);
        this.customString = customString;
    }

    public CustomException() {
    }

    public String getCustomString() {

        return customString;
    }

    public void setCustomString(String customString) {
        this.customString = customString;
    }
}
