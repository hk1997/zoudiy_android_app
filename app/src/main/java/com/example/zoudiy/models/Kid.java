package com.example.zoudiy.models;

public class Kid {

    String name;
    String surname;
    int age;
    int picture;
    String school;

    public Kid(String name, String surname, int age, int picture, String school) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.picture = picture;
        this.school = school;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
