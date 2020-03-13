package com.example.zoudiy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoudiy.R;
import com.example.zoudiy.interfaces.KidAdapter;
import com.example.zoudiy.models.Kid;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SignupKids extends AppCompatActivity {

    List<Kid> kidList;

    //the recyclerview
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupkids);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton addkidbutton = findViewById(R.id.addkidbutton);
        addkidbutton.setOnClickListener(v -> {
            Intent intent = new Intent(SignupKids.this, AddNewKid.class);
            startActivity(intent);
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(SignupKids.this, SignupAddr.class);
            startActivity(intent);
        });

        /*get kids from server*/


        kidList = new ArrayList<>();
        //adding some items to our list
        kidList.add(
                new Kid(
                        getIntent().getStringExtra("name"),
                        "Bhattacharyya",
                        21,
                        R.drawable.zoudiylogo1,
                        "APS Pune"
                ));
        //creating recyclerview adapter
        KidAdapter adapter = new KidAdapter(this, kidList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}
