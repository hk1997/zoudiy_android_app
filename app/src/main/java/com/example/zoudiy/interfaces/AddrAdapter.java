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
import com.example.zoudiy.models.AddressUser;

import java.util.List;

public class AddrAdapter extends RecyclerView.Adapter<AddrAdapter.AddrViewHolder> {

    private Context mCtx;
    private List<AddressUser> addrList;
    // private OnItemClickListener mListener;

   /* public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
        void onManageClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }*/

    public AddrAdapter(Context mCtx, List<AddressUser> addrList) {
        this.mCtx = mCtx;
        this.addrList = addrList;
    }

    @NonNull
    @Override
    public AddrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.addr_item, null);
        //return new AddrViewHolder(view, mListener);
        return new AddrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddrViewHolder holder, int position) {
        AddressUser addressUser = addrList.get(position);

        if(addressUser.getFullAddress()!=null){
            holder.addrFull.setText(addressUser.getFullAddress());
        }
        else
            holder.addrFull.setText(R.string.unavailable);

        if(addressUser.getCity()!=null){
            holder.addrCity.setText(addressUser.getCity());
        }
        else
            holder.addrCity.setText(R.string.unavailable);

        if(addressUser.getTag()!=null){
            holder.addrTag.setText(addressUser.getTag());
        }
        else
            holder.addrTag.setText(R.string.unavailable);
        if(addressUser.getPostalCode()!=null){
            holder.addrPostal.setText(addressUser.getPostalCode());
        }
        else
            holder.addrPostal.setText(R.string.unavailable);

        if(addressUser.getType()!=null){
            holder.addrLand.setText(addressUser.getType());
        }
        else
            holder.addrLand.setText(R.string.unavailable);

        holder.addrPicture.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.zoudiylogo1));

    }

    @Override
    public int getItemCount() {return addrList.size();}

    static class AddrViewHolder extends RecyclerView.ViewHolder{

        TextView addrCity, addrTag, addrPostal, addrLand, addrFull;
        ImageView addrPicture;
        //Button manage, delete;

        //AddrViewHolder(@NonNull View itemView, final AdapterView.OnItemClickListener listener) {
        AddrViewHolder(@NonNull View itemView) {
            super(itemView);

            addrCity = itemView.findViewById(R.id.addr_city);
            addrTag = itemView.findViewById(R.id.addr_tag);
            addrPostal = itemView.findViewById(R.id.addr_postal);
            addrLand = itemView.findViewById(R.id.addr_land);
            addrFull = itemView.findViewById(R.id.addr_full);
            addrPicture = itemView.findViewById(R.id.addr_picture);
            //manage = itemView.findViewById(R.id.manage);
            // delete = itemView.findViewById(R.id.delete);

           /* itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });

            delete.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(position);
                    }
                }
            });

            manage.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onManageClick(position);
                    }
                }
            });*/

        }
    }

}