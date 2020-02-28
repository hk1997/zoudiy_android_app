package com.example.zoudiy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zoudiy.R;
import com.example.zoudiy.utils.Preference;

public class  SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                if (Preference.getAccessToken(SplashActivity.this)!=null){
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(SplashActivity.this, Signup.class);
                    startActivity(i);
                }
                finish();
            }
        }, 3000);
    }
}
