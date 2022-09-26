package com.yotta.qcommerce.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.EditAddressActivity;
import com.yotta.qcommerce.activity.model.LocationClass;
import com.yotta.qcommerce.activity.model.SelectAddressClass;
import com.yotta.qcommerce.databinding.ItemLocationBinding;
import com.yotta.qcommerce.databinding.ItemSelectaddressBinding;

import java.util.List;

public class SelectAddressAdapter extends RecyclerView.Adapter<SelectAddressAdapter.MyViewHolder> {

    List<SelectAddressClass> list;
    String getAddress = "";
    addAddressClick addclickAddress;
    private int lastSelectedPosition = -1;
    Context context;
    String location = "0";

    public SelectAddressAdapter(Context context , List<SelectAddressClass> list, addAddressClick addclickAddress) {
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

        return new MyViewHolder(ItemSelectaddressBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SelectAddressClass modelObject = list.get(position);

        holder.binding.txtUserName.setText(modelObject.getUserName());
        holder.binding.txtUserAddress.setText(modelObject.getUserLocation());
        holder.binding.txtUserPhone.setText("Phone No:"+ " " +modelObject.getUserPhone());


        holder.binding.txtDeliverToAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = "1";
                final String modelObject = String.valueOf(list.get(position));
                lastSelectedPosition = position;
                getAddress = modelObject;
                Log.e(getAddress, "onClick: year");
                addclickAddress.onAddressClick(holder.binding.txtUserAddress.getText().toString(),location);
                notifyItemRangeChanged(0,list.size());            }
        });

        holder.binding.txtEditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditAddressActivity.class);
                intent.putExtra("from_addNewAddress","2");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemSelectaddressBinding binding;

        public MyViewHolder(@NonNull ItemSelectaddressBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
