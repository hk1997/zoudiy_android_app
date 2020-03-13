package com.example.zoudiy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.zoudiy.R;
import com.example.zoudiy.models.ProfUpdateResponse;
import com.example.zoudiy.utils.Preference;
import com.example.zoudiy.utils.RetrofitClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewKid extends AppCompatActivity {

    EditText kidET;
    String kidName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_kid);

        Button B1 = findViewById(R.id.buttonRegister);
        kidET = findViewById(R.id.add_kid_name);

        String token = Preference.getAccessToken(this);

        B1.setOnClickListener(v -> {

            kidName = kidET.getText().toString();

            Call<ProfUpdateResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .Addkid(token, kidName);
            call.enqueue(new Callback<ProfUpdateResponse>() {
                @Override
                public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                    Boolean s = response.body().getSuccess();
                    Log.d("Success", s + "");
                    Intent kids = new Intent(AddNewKid.this, SignupKids.class);
                    kids.putExtra("name", kidName);
                    startActivity(kids);
                    //Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                    Log.d("Failure", t.toString());
                    //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        });

    }
}
