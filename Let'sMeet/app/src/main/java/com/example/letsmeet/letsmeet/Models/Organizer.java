package com.example.letsmeet.letsmeet.Models;

/**
 * Created by fares on 7/6/15.
 */
public class Organizer {

    private String name;
    private String mail;
    private String phone;


    public Organizer(String name, String mail, String phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
