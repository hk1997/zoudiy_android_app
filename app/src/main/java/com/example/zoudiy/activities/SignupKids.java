package com.example.zoudiy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoudiy.R;
import com.example.zoudiy.interfaces.KidAdapter;
import com.example.zoudiy.models.Kid;
import com.example.zoudiy.models.ProfUpdateResponse;
import com.example.zoudiy.utils.Preference;
import com.example.zoudiy.utils.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupKids extends AppCompatActivity {

    List<Kid> kidList;
    RecyclerView recyclerView;
    KidAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupkids);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Refresh();

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

        LoadKids();
    }

    private void Refresh() {
        List<Kid> kidList = new ArrayList<>();
        adapter = new KidAdapter(this, kidList);
        recyclerView.setAdapter(adapter);

    }

    private void LoadKids() {
        String token = Preference.getAccessToken(this);
        Call<ProfUpdateResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .Getkids(token);
        call.enqueue(new Callback<ProfUpdateResponse>() {
            @Override
            public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                kidList = response.body().getData().getKidList();
                adapter = new KidAdapter(getApplicationContext(), kidList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                Log.d("Failure", t.toString());
            }
        });
    }


    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        Refresh();
        LoadKids();
        //Refresh your stuff here
    }

}
