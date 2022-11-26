package com.Proxym.EventManagementSys.dto;

public class messageResponse {
    private String message;

    public messageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
