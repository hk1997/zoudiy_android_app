package com.example.zoudiy.models;

import android.util.Log;

import com.example.zoudiy.utils.RetrofitClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public static void deleteKid(String _id) {
        //String token = Preference.getAccessToken(this);
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZTVlMzY2YmJkZDI0YTAwMTJhMjExMWIiLCJpYXQiOjE1ODUzNDIxOTcsImV4cCI6MTYxNjg3ODE5N30.bWxP6C2o2Fuxi4GlfRu-pzyaE_e6OnDt5qP6qeVD8H0";
        Call<ProfUpdateResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .Deletekid(token, _id);
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

    public static void updateKid(String _id) {
        //String token = Preference.getAccessToken(this);
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZTVlMzY2YmJkZDI0YTAwMTJhMjExMWIiLCJpYXQiOjE1ODUzNDIxOTcsImV4cCI6MTYxNjg3ODE5N30.bWxP6C2o2Fuxi4GlfRu-pzyaE_e6OnDt5qP6qeVD8H0";
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

}
