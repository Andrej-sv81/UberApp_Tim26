package com.example.uberapp_tim26.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CredentialsDTO {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    public CredentialsDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
