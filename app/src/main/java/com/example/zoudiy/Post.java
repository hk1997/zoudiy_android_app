package com.example.zoudiy;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("body")
    public String mobileno;
    public Post( String mobileno) {


        this.mobileno = mobileno;
    }
    public String getmobileno() {
        return mobileno;
    }
}
