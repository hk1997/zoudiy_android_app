package com.example.zoudiy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KidResponse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("coaching")
    @Expose
    private String coaching;


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

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCoaching() {
        return coaching;
    }

    public void setCoaching(String coaching) {
        this.coaching = coaching;
    }


}