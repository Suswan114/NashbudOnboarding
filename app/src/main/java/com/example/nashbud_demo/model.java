package com.example.nashbud_demo;

public class model {
    public model(String message, String status) {
        this.message = message;
        this.status = status;
    }

    String message;
    String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
