package com.vinz;

public class Contact {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        //constructor
    }
    public static Contact createContact(String name, String phoneNumber){
        return new Contact (name, phoneNumber); //using constructor to generate new contacts instead of using setters

    }
}
