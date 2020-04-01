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
    //Button manage, delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupaddr);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Refresh();

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
        //setButtons();

    }

    private void Refresh() {
        List<AddressUser> addrList = new ArrayList<>();
        adapter = new AddrAdapter(this, addrList);
        recyclerView.setAdapter(adapter);

        //LoadAddrs();

       /* manage = findViewById(R.id.manage);
        delete = findViewById(R.id.delete);
        adapter.setOnItemClickListener(new AddrAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("item ", "refresh");
            }

            @Override
            public void onDeleteClick(int position) {
                Log.e("delete ", "refresh");
            }
            @Override
            public void onManageClick(int position) {
                Log.e("manage ", "refresh");
            }
        });
        */
    }

  /*  public void setButtons() {
        manage = findViewById(R.id.manage);
        delete = findViewById(R.id.delete);
        Log.e("set buttons ", "buttons found");
        if(manage!=null)
        manage.setOnClickListener(v -> {
            Intent intent = new Intent(SignupAddr.this, AddNewAddr.class);
            startActivity(intent);
        });

        if(delete!=null)
        delete.setOnClickListener(v -> {
            Log.e("delete ", "setbuttons");
        });
        Log.e("set buttons ", "buttons set");
    }*/

    private void LoadAddrs() {
        //String token = Preference.getAccessToken(this);
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZTVlMzY2YmJkZDI0YTAwMTJhMjExMWIiLCJpYXQiOjE1ODUzNDIxOTcsImV4cCI6MTYxNjg3ODE5N30.bWxP6C2o2Fuxi4GlfRu-pzyaE_e6OnDt5qP6qeVD8H0";
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
                //setButtons();
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
        Refresh();
        LoadAddrs();
        //Refresh your stuff here
    }


}
