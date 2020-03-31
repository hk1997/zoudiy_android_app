package com.example.zoudiy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressUser {

    @SerializedName("coordinates")
    @Expose
    private AddressLatLng coordinates;
    @SerializedName("fullAddress")
    @Expose
    private String fullAddress;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("type")
    @Expose
    private String type;


    public AddressUser(AddressLatLng coordinates, String fullAddress, String postalCode, String tag, String landmark, String city, String type) {
        this.coordinates = coordinates;
        this.fullAddress = fullAddress;
        this.postalCode = postalCode;
        this.tag = tag;
        this.landmark = landmark;
        this.city = city;
        this.type = type;
    }

    public AddressLatLng getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(AddressLatLng coordinates) {
        this.coordinates = coordinates;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
