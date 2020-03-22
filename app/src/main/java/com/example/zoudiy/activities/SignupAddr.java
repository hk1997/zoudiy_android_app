package com.example.zoudiy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoudiy.R;
import com.example.zoudiy.interfaces.AddrAdapter;
import com.example.zoudiy.models.AddressUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SignupAddr extends AppCompatActivity{

    FloatingActionButton addAddr;
    List<AddressUser> addrList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupaddr);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addAddr = findViewById(R.id.add_addr);
        addAddr.setOnClickListener(v -> {
            Intent intent = new Intent(SignupAddr.this, AddNewAddr.class);
            startActivity(intent);
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(SignupAddr.this, HomeActivity.class);
            startActivity(intent);
        });

        addrList = new ArrayList<>();
        //adding some items to our list
        addrList.add(
                new AddressUser(
                        "Gwalior",
                        "474015",
                        "Hostel",
                        "Temporary",
                        "Hazira",
                        R.drawable.zoudiylogo1
                ));

        //creating recyclerview adapter
        AddrAdapter adapter = new AddrAdapter(this, addrList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

}
