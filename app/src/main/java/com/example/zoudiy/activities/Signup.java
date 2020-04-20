package com.example.zoudiy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zoudiy.R;
import com.example.zoudiy.models.ProfUpdateResponse;
import com.example.zoudiy.utils.Preference;
import com.example.zoudiy.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {

    String name, email, token;
    EditText nameET, emailET;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameET = findViewById(R.id.signup_input_name);
        emailET = findViewById(R.id.signup_input_email);

        token = Preference.getAccessToken(this);


        Button B1= findViewById(R.id.buttonRegister);
        B1.setOnClickListener(v -> {

            name = nameET.getText().toString();
            email = emailET.getText().toString();

            Call<ProfUpdateResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .Updateprof(token, name, email);
            call.enqueue(new Callback<ProfUpdateResponse>() {
                @Override
                public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                    try {
                        if(response.isSuccessful())
                        {
                            //get profile details here
                            //if complete go to home
                            //else go to complete profile section

                            ProfUpdateResponse profUpdateResponse = response.body();
                            Boolean s = profUpdateResponse.getSuccess();
                            Log.e("prof sent  ",s+"");
                            if(s) {
                                Intent intent = new Intent(Signup.this, SignupKids.class);
                                startActivity(intent);
                            }
                        }
                        else
                        {
                            Toast.makeText(Signup.this,"Error in update",Toast.LENGTH_LONG).show();
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                    Log.d("Failure",t.toString());
                }
            });

        });
    }
}
