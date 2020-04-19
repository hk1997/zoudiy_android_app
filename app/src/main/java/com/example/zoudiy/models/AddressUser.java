package com.example.zoudiy.models;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.zoudiy.activities.AddNewKid;
import com.example.zoudiy.utils.RetrofitClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    @SerializedName("_id")
    @Expose
    private String _id;


    public AddressUser(AddressLatLng coordinates, String fullAddress, String postalCode, String tag, String landmark, String city, String type, String _id) {
        this.coordinates = coordinates;
        this.fullAddress = fullAddress;
        this.postalCode = postalCode;
        this.tag = tag;
        this.landmark = landmark;
        this.city = city;
        this.type = type;
        this._id = _id;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public static void deleteAddress(String _id, String token) {

        Call<ProfUpdateResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .Deleteaddress(token, _id);
        call.enqueue(new Callback<ProfUpdateResponse>() {
            @Override
            public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                String msg = response.body().getMessage();
                Log.e("delete ", msg);
            }

            @Override
            public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                Log.d("Failure", t.toString());
            }
        });
    }

    public static void updateAddress(String _id, String token, Context context) {

        Intent intent = new Intent(context, AddNewKid.class);
        context.startActivity(intent);

        /*Call<ProfUpdateResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .Deleteaddress(token, _id);
        call.enqueue(new Callback<ProfUpdateResponse>() {
            @Override
            public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                String msg = response.body().getMessage();
                Log.e("delete ", msg);
            }

            @Override
            public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                Log.d("Failure", t.toString());
            }
        });*/

    }

}
