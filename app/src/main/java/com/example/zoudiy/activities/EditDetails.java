package com.example.zoudiy.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zoudiy.R;
import com.example.zoudiy.models.Kid;

import java.util.ArrayList;
import java.util.List;

public class EditDetails extends AppCompatActivity {

    String type, _id, token;
    List<Kid> kidList = new ArrayList<>();
    Kid kid;

    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        Button B1 = findViewById(R.id.buttonRegister);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        ed6 = findViewById(R.id.ed6);
        ed7 = findViewById(R.id.ed7); //type

        type = getIntent().getStringExtra("type");
        _id = getIntent().getStringExtra("id");
        kid = (Kid) getIntent().getSerializableExtra("kid");

        //Log.e("kid shits", kid.get_id()+" "+kid.getName());

        switch (type) {
            case "kid":
                updateKid(kid);
                break;
            case "address":
                updateAddress();
                break;
            default:
                Toast.makeText(getApplicationContext(), "some error", Toast.LENGTH_LONG).show();
        }

        B1.setOnClickListener(v -> alertDialog());

    }

    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to save changes?");
        dialog.setTitle("Confirm");
        dialog.setPositiveButton("Yes",
                (dialog12, which) -> {

                });
        dialog.setNegativeButton("Cancel", (dialog1, which) -> Toast.makeText(getApplicationContext(), "Operation Cancelled", Toast.LENGTH_LONG).show());
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    private void updateAddress() {
        ed7.setVisibility(View.VISIBLE);
        //update address
    }

    private void updateKid(Kid kid) {
        ed7.setVisibility(View.GONE);
        
        ed1.setHint("Name");
        ed2.setHint("D.O.B");
        ed3.setHint("Class");
        ed4.setHint("School");
        ed5.setHint("Coaching");
        ed6.setHint("Home");

        ed1.setText(kid.getName());
        ed2.setText(kid.getDob());
        ed3.setText(kid.getStandard());
        ed4.setText(kid.getSchool());
        ed5.setText(kid.getCoaching());
        ed6.setText(kid.getHome());



        // add details to edit text
        //get detials and update
        //update kid
    }


}
