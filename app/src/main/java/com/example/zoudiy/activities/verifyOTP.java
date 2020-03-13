package com.example.zoudiy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zoudiy.R;
import com.example.zoudiy.models.OtpResponse;
import com.example.zoudiy.utils.Preference;
import com.example.zoudiy.utils.RetrofitClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class verifyOTP extends AppCompatActivity {


    EditText OTP1,OTP3,OTP2,OTP4,OTP5,OTP6;
    public String getotp;
    Button verifyotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verifyotp);

        OTP1 = findViewById(R.id.et1);
        OTP2 = findViewById(R.id.et2);
        OTP3 = findViewById(R.id.et3);
        OTP4 = findViewById(R.id.et4);
        OTP5 = findViewById(R.id.et5);
        OTP6 = findViewById(R.id.et6);

        OTP1.requestFocus();

        OTP1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1)
                {
                    OTP2.requestFocus();
                }
                else if(s.length()==0)
                {
                    OTP1.clearFocus();
                }
            }
        });

        OTP2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1)
                {
                    OTP3.requestFocus();
                }
                else if(s.length()==0)
                {
                    OTP2.clearFocus();
                    OTP1.requestFocus();
                }
            }
        });

        OTP3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1)
                {
                    OTP4.requestFocus();
                }
                else if(s.length()==0)
                {

                    OTP3.clearFocus();
                    OTP2.requestFocus();
                }
            }
        });

        OTP4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1)
                {
                    OTP5.requestFocus();
                }
                else if(s.length()==0)
                {

                    OTP4.clearFocus();
                    OTP3.requestFocus();
                }
            }
        });

        OTP5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1)
                {
                    OTP6.requestFocus();
                }
                else if(s.length()==0)
                {

                    OTP5.clearFocus();
                    OTP4.requestFocus();
                }
            }
        });

        final String mobileNo = getIntent().getStringExtra("mobile");

        OTP6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1)
                {
                    verifyotp.setEnabled(true);

                }
                else if(s.length()==0)
                {
                    OTP6.clearFocus();
                    OTP5.requestFocus();
                }
            }
        });

        verifyotp = findViewById(R.id.verifyotp);
        verifyotp.setOnClickListener(v -> {

            getotp= OTP1.getText().toString()+OTP2.getText().toString()+OTP3.getText().toString()+OTP4.getText().toString()+OTP5.getText().toString()+OTP6.getText().toString();

            Call<OtpResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .Verifyotp(mobileNo,getotp);
            call.enqueue(new Callback<OtpResponse>() {
                @Override
                public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
                    try {
                        if(response.isSuccessful())
                        {
                            //get profile details here
                            //if complete go to home
                            //else go to complete profile section

                            OtpResponse otpResponse = response.body();

                            String token=otpResponse.getData().getToken();
                            Log.e("token is : ", token);
                            Preference.setAccessToken(verifyOTP.this,token);

                            Intent intent=new Intent(verifyOTP.this,Signup.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(verifyOTP.this,"Invalid OTP",Toast.LENGTH_LONG).show();
                        }
                        //Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<OtpResponse> call, Throwable t) {
                    Log.d("Failure",t.toString());
                    //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        });

    }

}
