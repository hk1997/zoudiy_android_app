package com.example.zoudiy;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    EditText MobileNo,OTP1,OTP3,OTP2,OTP4;
    public String mobileNo,getotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice);

        MobileNo = (EditText) findViewById(R.id.editText3);

        MobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==10)
                {
                    mobileNo = "+91" + " " + MobileNo.getText().toString();
                    Call<ResponseBody> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .Sendotp(mobileNo);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                String s = response.body().string();
                                Log.d("Success",s);
                                //Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.d("Failure",t.toString());
                            //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                    OTP1.requestFocus();
                }
                else if(s.length()<10)
                {
                    return;
                }
            }
        });

        OTP1 = (EditText) findViewById(R.id.et1);
        OTP2 = (EditText) findViewById(R.id.et2);
        OTP3 = (EditText) findViewById(R.id.et3);
        OTP4 = (EditText) findViewById(R.id.et4);

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
                    OTP2.requestFocus();
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
                    OTP3.requestFocus();
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
                    getotp= OTP1.getText().toString()+OTP2.getText().toString()+OTP3.getText().toString()+OTP4.getText().toString();
                    mobileNo = "+91" + " " + MobileNo.getText().toString();
                    Call<ResponseBody> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .Verifyotp(mobileNo,getotp);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                String s = response.body().string();
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else if(s.length()==0)
                {
                    OTP4.clearFocus();
                    OTP3.requestFocus();
                }
            }
        });

    }
}
