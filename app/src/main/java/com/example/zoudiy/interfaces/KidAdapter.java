package com.example.zoudiy.interfaces;

import android.content.Context;
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
        holder.kidName.setText(kid.getName());
        holder.kidSurname.setText(kid.getSurname());
        holder.kidAge.setText(String.valueOf(kid.getAge()));
        holder.kidSchool.setText(String.valueOf(kid.getSchool()));

        holder.kidPicture.setImageDrawable(mCtx.getResources().getDrawable(kid.getPicture()));

    }

    @Override
    public int getItemCount() {
        return kidList.size();
    }

    static class KidViewHolder extends RecyclerView.ViewHolder{

        TextView kidName, kidSurname, kidSchool, kidAge;
        ImageView kidPicture;

        KidViewHolder(@NonNull View itemView) {
            super(itemView);

            kidName = itemView.findViewById(R.id.kidName);
            kidSurname = itemView.findViewById(R.id.kidSurname);
            kidAge = itemView.findViewById(R.id.kidAge);
            kidSchool = itemView.findViewById(R.id.kidSchool);
            kidPicture = itemView.findViewById(R.id.kidPicture);

        }
    }

}
