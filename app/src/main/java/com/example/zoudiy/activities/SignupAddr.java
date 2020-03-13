package com.example.zoudiy.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zoudiy.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SignupAddr extends AppCompatActivity{

    FloatingActionButton addAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupaddr);

        addAddr = findViewById(R.id.add_addr);
        addAddr.setOnClickListener(v -> {
            Intent intent = new Intent(SignupAddr.this, AddNewAddr.class);
            startActivity(intent);
        });

    }

}
