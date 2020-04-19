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
import com.example.zoudiy.models.ProfUpdateResponse;
import com.example.zoudiy.utils.Preference;
import com.example.zoudiy.utils.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupAddr extends AppCompatActivity{

    List<AddressUser> addrList;
    RecyclerView recyclerView;
    AddrAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupaddr);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Refresh();

        FloatingActionButton addAddr = findViewById(R.id.add_addr);
        addAddr.setOnClickListener(v -> {
            Intent intent = new Intent(SignupAddr.this, AddNewAddr.class);
            startActivity(intent);
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(SignupAddr.this, HomeActivity.class);
            startActivity(intent);
        });
        LoadAddrs();

    }

    private void Refresh() {
        List<AddressUser> addrList = new ArrayList<>();
        adapter = new AddrAdapter(this, addrList);
        recyclerView.setAdapter(adapter);

    }

    private void LoadAddrs() {
        String token = Preference.getAccessToken(this);
        //String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZTVlMzY2YmJkZDI0YTAwMTJhMjExMWIiLCJpYXQiOjE1ODUzNDIxOTcsImV4cCI6MTYxNjg3ODE5N30.bWxP6C2o2Fuxi4GlfRu-pzyaE_e6OnDt5qP6qeVD8H0";
        Call<ProfUpdateResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .GetAddresses(token);
        call.enqueue(new Callback<ProfUpdateResponse>() {
            @Override
            public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                addrList = response.body().getData().getAddrList();
                adapter = new AddrAdapter(getApplicationContext(), addrList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                Log.d("Failure", t.toString());
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        Refresh();
        LoadAddrs();

    }


}
