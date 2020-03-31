package com.example.zoudiy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("kids")
    @Expose
    private List<Kid> kidList;
    @SerializedName("addresses")
    @Expose
    private List<AddressUser> addrList;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Kid> getKidList() {
        return kidList;
    }

    public void setKidList(List<Kid> kidList) {
        this.kidList = kidList;
    }

    public List<AddressUser> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<AddressUser> addrList) {
        this.addrList = addrList;
    }
}
