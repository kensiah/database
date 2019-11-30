package com.example.phonenumberrecordapp;

public class Contact {
    private int id;
    private String name,phoneNumber;
    public static final String TABLE_NAME="contacts";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE_NUMBER="phonenumber";

    public int getId(){
        return id;
    }

    public void setId(String name,int id) {
        this.id = id;
    }

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
