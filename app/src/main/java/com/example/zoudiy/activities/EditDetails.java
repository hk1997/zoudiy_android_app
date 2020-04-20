package com.example.zoudiy.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zoudiy.R;
import com.example.zoudiy.models.Kid;
import com.example.zoudiy.models.ProfUpdateResponse;
import com.example.zoudiy.utils.Preference;
import com.example.zoudiy.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditDetails extends AppCompatActivity {

    String type, _id, token;
    List<Kid> kidList = new ArrayList<>();
    Kid selkid = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        Button B1 = findViewById(R.id.buttonRegister);

        type = getIntent().getStringExtra("type");
        _id = getIntent().getStringExtra("id");

        token = Preference.getAccessToken(this);

        B1.setOnClickListener(v -> alertDialog());

    }

    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to save changes?");
        dialog.setTitle("Confirm");
        dialog.setPositiveButton("Yes",
                (dialog12, which) -> {

                    switch (type) {
                        case "kid":
                            updateKid();
                            break;
                        case "address":
                            updateAddress();
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_LONG).show();
                    }

                });
        dialog.setNegativeButton("Cancel", (dialog1, which) -> Toast.makeText(getApplicationContext(), "Operation Cancelled", Toast.LENGTH_LONG).show());
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    private void updateAddress() {


        //update address
    }

    private void updateKid() {
        Call<ProfUpdateResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .Getkids(token);
        call.enqueue(new Callback<ProfUpdateResponse>() {
            @Override
            public void onResponse(Call<ProfUpdateResponse> call, Response<ProfUpdateResponse> response) {
                for (Kid kid : kidList = response.body().getData().getKidList())
                    if (kid.get_id().equals("_id")) selkid = kid;
            }

            @Override
            public void onFailure(Call<ProfUpdateResponse> call, Throwable t) {
                Log.d("Failure", t.toString());
            }
        });


        // add details to edit text
        //get detials and update
        //update kid
    }


}
