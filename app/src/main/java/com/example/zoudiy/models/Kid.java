package com.example.zoudiy.models;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.zoudiy.activities.EditDetails;
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
    @SerializedName("home")
    @Expose
    private String home;


    public Kid(String name, String dob, String standard, String school, String coaching, String home, String _id) {
        this.name = name;
        this.dob = dob;
        this.school = school;
        this.standard = standard;
        this.coaching = coaching;
        this.home = home;
        this._id = _id;
    }

    public static void deleteKid(String _id, String token, Context context) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage("Are you sure you want to delete kid?");
        dialog.setTitle("Confirm");
        dialog.setPositiveButton("Yes",
                (dialog12, which) -> {

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

                });
        dialog.setNegativeButton("Cancel", (dialog1, which) -> Toast.makeText(context, "Operation Cancelled", Toast.LENGTH_LONG).show());
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();


    }

    public static void updateKid(String _id, Context context) {

        Intent intent = new Intent(context, EditDetails.class);
        intent.putExtra("id", _id);
        intent.putExtra("type", "kid");
        context.startActivity(intent);

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


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

}
