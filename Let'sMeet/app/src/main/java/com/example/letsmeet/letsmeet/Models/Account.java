package com.example.letsmeet.letsmeet.Models;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Soot_Win on 2015-03-21.
 */
public class Account {

    @DatabaseField
    String email;
    @DatabaseField
    String nickName;
    @DatabaseField
    String fullName;
    @DatabaseField
    String phoneNumber;
    @DatabaseField
    Boolean showName;
    @DatabaseField
    String avatarUrl;

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", showName=" + showName +
                ", gravatarUrl='" + avatarUrl + '\'' +
                '}';
    }



    public Account(String email, String nickName, String fullName, String phoneNumber, Boolean showName, String avatarUrl) {
        this.email = email;
        this.nickName = nickName;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.showName = showName;
        this.avatarUrl = avatarUrl;
    }

    public Account(String email, String nickName, String gravatarUrl, String fullName, Boolean showName) {
        this.email = email;
        this.nickName = nickName;
        this.avatarUrl = gravatarUrl;
        this.fullName = fullName;
        this.showName = showName;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getShowName() {
        return showName;
    }

    public String getGravatarUrl() {
        return avatarUrl;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setShowName(Boolean showName) {
        this.showName = showName;
    }

    public void setGravatarUrl(String gravatarUrl) {
        this.avatarUrl = gravatarUrl;
    }
}