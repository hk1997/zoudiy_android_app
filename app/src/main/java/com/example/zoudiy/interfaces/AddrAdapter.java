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
import com.example.zoudiy.models.AddressUser;

import java.util.List;

public class AddrAdapter extends RecyclerView.Adapter<AddrAdapter.AddrViewHolder> {

    private Context mCtx;
    private List<AddressUser> addrList;

    public AddrAdapter(Context mCtx, List<AddressUser> addrList) {
        this.mCtx = mCtx;
        this.addrList = addrList;
    }

    @NonNull
    @Override
    public AddrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.addr_item, null);
        return new AddrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddrViewHolder holder, int position) {
        //AddressUser addressUser = addrList.get(position);
        AddressUser addressUser = addrList.get(0);
        Log.e("city ", addressUser.getNickname()+" "+position);
        //binding the data with the viewholder views
        holder.addrCity.setText(addressUser.getCity());
        holder.addrNickname.setText(addressUser.getNickname());
        holder.addrPostal.setText(String.valueOf(addressUser.getPostalCode()));
        holder.addrType.setText(String.valueOf(addressUser.getType()));

        holder.addrPicture.setImageDrawable(mCtx.getResources().getDrawable(addressUser.getPicture()));

    }

    @Override
    public int getItemCount() {return addrList.size();}

    static class AddrViewHolder extends RecyclerView.ViewHolder{

        TextView addrCity, addrNickname, addrPostal, addrType;
        ImageView addrPicture;

        AddrViewHolder(@NonNull View itemView) {
            super(itemView);

            addrCity = itemView.findViewById(R.id.addr_city);
            addrNickname = itemView.findViewById(R.id.addr_nickname);
            addrPostal = itemView.findViewById(R.id.addr_postal);
            addrType = itemView.findViewById(R.id.addr_type);
            addrPicture = itemView.findViewById(R.id.addr_picture);

        }
    }

}