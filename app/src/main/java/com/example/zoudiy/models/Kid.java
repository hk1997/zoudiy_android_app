package com.example.zoudiy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kid {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("class")
    @Expose
    private String standard;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("coaching")
    @Expose
    private String coaching;
    @SerializedName("_id")
    @Expose
    private String _id;

    int picture;

    public Kid(String name, String dob, String standard, String school, String coaching, int picture, String _id) {
        this.name = name;
        this.dob = dob;
        this.school = school;
        this.standard = standard;
        this.coaching = coaching;
        this.picture = picture;
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getCoaching() {
        return coaching;
    }

    public void setCoaching(String coaching) {
        this.coaching = coaching;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
