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
        AddressUser addressUser = addrList.get(position);

        if(addressUser.getFullAddress()!=null){
            holder.addrFull.setText(addressUser.getFullAddress());
        }
        else
            holder.addrFull.setText("not found");

        if(addressUser.getCity()!=null){
            holder.addrCity.setText(addressUser.getCity());
        }
        else
            holder.addrCity.setText("not found");

        if(addressUser.getTag()!=null){
            holder.addrTag.setText(addressUser.getTag());
        }
        else
            holder.addrTag.setText("not found");
        if(addressUser.getPostalCode()!=null){
            holder.addrPostal.setText(String.valueOf(addressUser.getPostalCode()));
        }
        else
            holder.addrPostal.setText("not found");

        if(addressUser.getType()!=null){
            holder.addrLand.setText(String.valueOf(addressUser.getType()));
        }
        else
            holder.addrLand.setText("not found");

        holder.addrPicture.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.zoudiylogo1));

    }

    @Override
    public int getItemCount() {return addrList.size();}

    static class AddrViewHolder extends RecyclerView.ViewHolder{

        TextView addrCity, addrTag, addrPostal, addrLand, addrFull;
        ImageView addrPicture;

        AddrViewHolder(@NonNull View itemView) {
            super(itemView);

            addrCity = itemView.findViewById(R.id.addr_city);
            addrTag = itemView.findViewById(R.id.addr_tag);
            addrPostal = itemView.findViewById(R.id.addr_postal);
            addrLand = itemView.findViewById(R.id.addr_land);
            addrFull = itemView.findViewById(R.id.addr_full);
            addrPicture = itemView.findViewById(R.id.addr_picture);

        }
    }

}