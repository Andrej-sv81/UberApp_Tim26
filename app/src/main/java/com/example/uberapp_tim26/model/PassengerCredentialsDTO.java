package com.example.uberapp_tim26.model;

public class PassengerCredentialsDTO {
    private Integer id;
    private String email;

    public PassengerCredentialsDTO() {
    }

    public PassengerCredentialsDTO(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
