package com.example.zoudiy.models;

public class AddressUser {

    String city;
    String postalCode;
    String nickname;
    String type;
    String locality;
    int picture;



    public AddressUser(String city, String postalCode, String nickname, String type, String locality, int picture) {
        this.city = city;
        this.postalCode = postalCode;
        this.nickname = nickname;
        this.type = type;
        this.locality = locality;
        this.picture = picture;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
