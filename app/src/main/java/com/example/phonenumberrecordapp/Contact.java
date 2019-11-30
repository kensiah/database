package com.example.phonenumberrecordapp;

public class Contact {
    private String name,phoneNumber;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
