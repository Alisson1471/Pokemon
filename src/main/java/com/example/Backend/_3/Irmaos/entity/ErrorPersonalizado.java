package com.example.Backend._3.Irmaos.entity;

public class ErrorPersonalizado {

    private String message;

    public ErrorPersonalizado(String message) { this.message = message; }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
