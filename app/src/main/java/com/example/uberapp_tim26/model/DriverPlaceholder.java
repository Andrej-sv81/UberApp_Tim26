package com.example.uberapp_tim26.model;

public class DriverPlaceholder {
    private String name;
    private String surname;
    private String id;
    private String phone;
    private String email;
    int img;


    public DriverPlaceholder(String name, String surname, String id, String phone, String email, int img) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
