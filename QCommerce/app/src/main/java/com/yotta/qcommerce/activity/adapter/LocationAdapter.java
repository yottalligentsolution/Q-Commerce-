package com.yotta.qcommerce.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.model.LocationClass;
import com.yotta.qcommerce.databinding.ItemLocationBinding;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {

    List<LocationClass> list;
    String getAddress = "";
    addAddressClick addclickAddress;
    private int lastSelectedPosition = -1;
    Context context;
    String location = "0";

    public LocationAdapter(Context context ,List<LocationClass> list,  addAddressClick addclickAddress) {
        this.context = context;
        this.list = list;
        this.addclickAddress = addclickAddress;
    }

    public interface addAddressClick {
        void onAddressClick(String address, String location);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LocationClass modelObject = list.get(position);

        holder.binding.txtChooseLocation.setText(modelObject.getAddress());

        if (position == lastSelectedPosition) {
            holder.binding.relLocation.setBackgroundResource(R.drawable.border_select);
        } else{
            holder.binding.relLocation.setBackgroundResource(R.drawable.border_not_select);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = "1";
                final String modelObject = String.valueOf(list.get(position));
                lastSelectedPosition = position;
                holder.binding.relLocation.setBackgroundResource(R.drawable.border_select);
                getAddress = modelObject;
                Log.e(getAddress, "onClick: year");
                addclickAddress.onAddressClick(holder.binding.txtChooseLocation.getText().toString(),location);
                notifyItemRangeChanged(0,list.size());            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemLocationBinding binding;

        public MyViewHolder(@NonNull ItemLocationBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
