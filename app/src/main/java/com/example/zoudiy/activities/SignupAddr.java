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
import com.example.zoudiy.interfaces.KidAdapter;
import com.example.zoudiy.models.AddressUser;
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

public class SignupAddr extends AppCompatActivity{

    FloatingActionButton addAddr;
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

        List<AddressUser> addrList = new ArrayList<>();

        adapter = new AddrAdapter(this, addrList);
        recyclerView.setAdapter(adapter);

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

        LoadAddrs();

    }

    private void LoadAddrs() {
        String token = Preference.getAccessToken(this);
        Call<ProfUpdateResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .GetAddresses(token);
        call.enqueue(new Callback<ProfUpdateResponse>() {
            @Override
            public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                addrList = response.body().getData().getAddrList();
                Log.d("Success", "" + addrList.get(0).getFullAddress() + " " + addrList.size());
                adapter = new AddrAdapter(getApplicationContext(), addrList);
                Log.d("Success adapter call", "" + addrList.get(0).getType());
                //setting adapter to recyclerview
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                Log.d("Failure", t.toString());
                //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        List<AddressUser> addrList = new ArrayList<>();

        adapter = new AddrAdapter(this, addrList);
        recyclerView.setAdapter(adapter);
        LoadAddrs();
        //Refresh your stuff here
    }


}
