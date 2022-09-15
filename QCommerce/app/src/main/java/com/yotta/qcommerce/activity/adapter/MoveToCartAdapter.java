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
import com.yotta.qcommerce.activity.model.MoveToCartItem;
import com.yotta.qcommerce.databinding.ItemCartBinding;
import com.yotta.qcommerce.databinding.ItemMovecartBinding;

import java.util.List;

public class MoveToCartAdapter extends RecyclerView.Adapter<MoveToCartAdapter.MyViewHolder> {

    List<MoveToCartItem> list;
    addAddressClick addclickAddress;
    private int lastSelectedPosition = -1;
    Context context;
    String location = "0";
    int count;
    private int counter ;
    String str_finalvalue="",str_add="",userid="",baseurl;
    int productprice;
    Toast toast;


    public MoveToCartAdapter(Context context , List<MoveToCartItem> list) {
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

        return new MyViewHolder(ItemMovecartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MoveToCartItem modelObject = list.get(position);

        holder.binding.imageview.setImageResource(modelObject.getProductImage());
        holder.binding.txtProductname.setText(modelObject.getProductName());
        holder.binding.txtItemdescription.setText("Model"+" "+modelObject.getProductName());
        holder.binding.txtPrice.setText("Rs"+" "+modelObject.getProductPrice());


        counter = Integer.valueOf(modelObject.getProductQuantity());
        productprice = Integer.valueOf(modelObject.getProductPrice());


        holder.binding.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter + 1;
                count = counter * Integer.valueOf(modelObject.getProductPrice());
                str_finalvalue = String.valueOf(count);
                holder.binding.txtPrice.setText("Rs" + "" +str_finalvalue);
                str_add = String.valueOf(counter);
                holder.binding.txtCount.setText(str_add);
            }
        });

        holder.binding.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 1)
                {
                    toast.setText("Quantity can't be 0");
                    toast.show();

                    counter = 1;

                    str_finalvalue = String.valueOf(productprice);

                    holder.binding.txtPrice.setText("Rs"+ "" +str_finalvalue);
                    String temp1 = String.valueOf(counter);
                    holder.binding.txtCount.setText(temp1);
                }else if (counter > 1){
                    counter = counter - 1;
                    count = counter * Integer.valueOf(modelObject.getProductPrice());

                    str_finalvalue = String.valueOf(count);

                    holder.binding.txtPrice.setText("Rs" + "" +str_finalvalue);

                    String temp1 = String.valueOf(counter);
                    holder.binding.txtCount.setText(temp1);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemMovecartBinding binding;

        public MyViewHolder(@NonNull ItemMovecartBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
