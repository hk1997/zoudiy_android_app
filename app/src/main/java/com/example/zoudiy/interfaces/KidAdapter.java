package com.example.zoudiy.interfaces;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoudiy.R;
import com.example.zoudiy.models.Kid;

import java.util.List;

public class KidAdapter extends RecyclerView.Adapter<KidAdapter.KidViewHolder> {

    private Context mCtx;
    private List<Kid> kidList;

    public KidAdapter(Context mCtx, List<Kid> kidList) {
        this.mCtx = mCtx;
        this.kidList = kidList;
        //Log.d("Success in constructor", ""+ kidList.get(0).getName());
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

        KidViewHolder(@NonNull View itemView) {
            super(itemView);

            kidName = itemView.findViewById(R.id.kidName);
            kidStandard = itemView.findViewById(R.id.kidStandard);
            kidAge = itemView.findViewById(R.id.kidAge);
            kidSchool = itemView.findViewById(R.id.kidSchool);
            kidCoaching = itemView.findViewById(R.id.kidCoaching);
            kidPicture = itemView.findViewById(R.id.kidPicture);

        }
    }

}
