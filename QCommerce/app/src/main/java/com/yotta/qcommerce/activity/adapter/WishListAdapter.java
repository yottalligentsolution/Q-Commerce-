package com.yotta.qcommerce.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yotta.qcommerce.activity.model.CartItemClass;
import com.yotta.qcommerce.activity.model.WishListClass;
import com.yotta.qcommerce.databinding.ItemCartBinding;
import com.yotta.qcommerce.databinding.ItemWishlistBinding;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.MyViewHolder> {

    List<WishListClass> list;
    addAddressClick addclickAddress;
    private int lastSelectedPosition = -1;
    Context context;
    String location = "0";
    int count;
    private int counter ;
    String str_finalvalue="",str_add="",userid="",baseurl;
    int productprice;
    Toast toast;


    public WishListAdapter(Context context , List<WishListClass> list) {
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

        return new MyViewHolder(ItemWishlistBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        WishListClass modelObject = list.get(position);

        holder.binding.imageview.setImageResource(modelObject.getProductImage());
        holder.binding.txtProductname.setText(modelObject.getProductName());
        holder.binding.txtPrice.setText("Rs"+" "+modelObject.getProductPrice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemWishlistBinding binding;

        public MyViewHolder(@NonNull ItemWishlistBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
