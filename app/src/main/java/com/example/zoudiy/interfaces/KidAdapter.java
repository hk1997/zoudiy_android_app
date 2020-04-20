package com.example.zoudiy.interfaces;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoudiy.R;
import com.example.zoudiy.activities.EditDetails;
import com.example.zoudiy.models.Kid;
import com.example.zoudiy.utils.Preference;

import java.util.List;

public class KidAdapter extends RecyclerView.Adapter<KidAdapter.KidViewHolder> {

    private Context mCtx;
    private List<Kid> kidList;

    public KidAdapter(Context mCtx, List<Kid> kidList) {
        this.mCtx = mCtx;
        this.kidList = kidList;

    }

    @NonNull
    @Override
    public KidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.kid_item, null);
        return new KidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KidViewHolder holder, int position) {
        Kid kid = kidList.get(position);
        String token = Preference.getAccessToken(mCtx);

        holder.manage.setOnClickListener(v -> {
            Intent intent = new Intent(mCtx, EditDetails.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("id", kid.get_id());
            intent.putExtra("type", "kid");
            intent.putExtra("kid", kid);
            mCtx.startActivity(intent);
            //Kid.updateKid(kid.get_id(), mCtx);
            Toast.makeText(mCtx, "Manage btn fetch:" + kid.get_id(), Toast.LENGTH_SHORT).show();
        });
        holder.delete.setOnClickListener(v -> {
            Kid.deleteKid(kid.get_id(), token, mCtx);
            Toast.makeText(mCtx, "Delete btn fetch:" + kid.get_id(), Toast.LENGTH_SHORT).show();
        });

        //binding the data with the viewholder views
        if (kid.getName() != null)
            holder.kidName.setText(kid.getName());
        else
            holder.kidName.setText("Name not updated");

        if (kid.getStandard() != null)
            holder.kidStandard.setText(kid.getStandard());
        else
            holder.kidStandard.setText("Class not updated");

        if (kid.getDob() != null)
            holder.kidAge.setText(kid.getDob());
        else
            holder.kidAge.setText("DoB not updated");

        if (kid.getSchool() != null)
            holder.kidSchool.setText(kid.getSchool());
        else
            holder.kidSchool.setText("School not updated");

        if (kid.getCoaching() != null)
            holder.kidCoaching.setText(kid.getCoaching());
        else
            holder.kidCoaching.setText("Coaching not updated");

        holder.kidPicture.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.zoudiylogo1));

    }

    @Override
    public int getItemCount() {
        return kidList.size();
    }

    static class KidViewHolder extends RecyclerView.ViewHolder {

        TextView kidName, kidStandard, kidSchool, kidAge, kidCoaching;
        ImageView kidPicture;
        Button manage, delete;

        KidViewHolder(@NonNull View itemView) {
            super(itemView);

            kidName = itemView.findViewById(R.id.kidName);
            kidStandard = itemView.findViewById(R.id.kidStandard);
            kidAge = itemView.findViewById(R.id.kidAge);
            kidSchool = itemView.findViewById(R.id.kidSchool);
            kidCoaching = itemView.findViewById(R.id.kidCoaching);
            kidPicture = itemView.findViewById(R.id.kidPicture);
            manage = itemView.findViewById(R.id.manage);
            delete = itemView.findViewById(R.id.delete);

        }
    }

}
