package com.example.zoudiy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zoudiy.R;
import com.example.zoudiy.models.ProfUpdateResponse;
import com.example.zoudiy.utils.Preference;
import com.example.zoudiy.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewKid extends AppCompatActivity {

    EditText kidNameET, kidDobET, kidStandardET, kidSchoolET, kidCoachingET;
    String kidName, kidDob, kidStandard, kidSchool, kidCoaching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_kid);

        Button B1 = findViewById(R.id.buttonRegister);

        kidNameET = findViewById(R.id.add_kid_name);
        kidDobET = findViewById(R.id.dob);
        kidStandardET = findViewById(R.id.standard);
        kidSchoolET = findViewById(R.id.school);
        kidCoachingET = findViewById(R.id.coaching);


        String token = Preference.getAccessToken(this);

        B1.setOnClickListener(v -> {

            alertDialog(token);

        });

    }

    private void alertDialog(String token) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to add new kid?");
        dialog.setTitle("Confirm");
        dialog.setPositiveButton("YES",
                (dialog12, which) -> {

                    kidName = kidNameET.getText().toString();
                    kidDob = kidDobET.getText().toString();
                    kidStandard = kidStandardET.getText().toString();
                    //kidSchool = kidSchoolET.getText().toString();
                    //kidCoaching = kidCoachingET.getText().toString();
                    kidSchool = "";
                    kidCoaching = "";

                    Call<ProfUpdateResponse> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .Addkid(token, kidName, kidDob, kidStandard, kidSchool, kidCoaching);
                    call.enqueue(new Callback<ProfUpdateResponse>() {
                        @Override
                        public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                            Boolean s = response.body().getSuccess();
                            Log.d("Success", s + "");
                            Intent kids = new Intent(AddNewKid.this, SignupKids.class);
                            startActivity(kids);
                            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                            Log.d("Failure", t.toString());
                            //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                });
        dialog.setNegativeButton("Cancel", (dialog1, which) -> Toast.makeText(getApplicationContext(),"Operation Cancelled",Toast.LENGTH_LONG).show());
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

}
