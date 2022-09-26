package com.yotta.qcommerce.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.model.BrandFocusClass;
import com.yotta.qcommerce.activity.model.OrdersClass;
import com.yotta.qcommerce.databinding.ItemBrandfocusBinding;
import com.yotta.qcommerce.databinding.ItemOrdersBinding;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {

    List<OrdersClass> list;
    String getAddress = "";
    addAddressClick addclickAddress;
    private int lastSelectedPosition = -1;
    Context context;
    String location = "0";
    int count;
    private int counter ;
    String str_finalvalue="",str_add="",userid="",baseurl;
    int productprice;
    Toast toast;


    public OrdersAdapter(Context context , List<OrdersClass> list) {
        this.context = context;
        this.list = list;
        toast = Toast.makeText(context,"",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,0);

    }

    public interface addAddressClick {
        void onAddressClick(String address, String location);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(ItemOrdersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        OrdersClass modelObject = list.get(position);

        holder.binding.txtProductName.setText(modelObject.getProductName());
        holder.binding.txtOrderId.setText("Order ID"+ "#" + " " +modelObject.getOrderID());
        holder.binding.txtDateAndTime.setText(modelObject.getOrderTimeAndDate());

        holder.binding.cardOrder.setBackgroundResource(R.color.background);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemOrdersBinding binding;

        public MyViewHolder(@NonNull ItemOrdersBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
