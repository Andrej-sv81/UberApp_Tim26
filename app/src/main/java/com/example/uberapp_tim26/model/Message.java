package com.example.uberapp_tim26.model;

public class Message {
    private String username;
    private String title;
    private String message;

    public Message(String username, String title, String message){
        this.username = username;
        this.title = title;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
