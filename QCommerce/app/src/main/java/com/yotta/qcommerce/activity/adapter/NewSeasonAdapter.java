package com.yotta.qcommerce.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yotta.qcommerce.activity.model.NewArrivalsClass;
import com.yotta.qcommerce.activity.model.NewSeasonClass;
import com.yotta.qcommerce.databinding.ItemTreandingnearyouBinding;

import java.util.List;

public class NewSeasonAdapter extends RecyclerView.Adapter<NewSeasonAdapter.MyViewHolder> {

    List<NewSeasonClass> list;
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


    public NewSeasonAdapter(Context context , List<NewSeasonClass> list) {
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

        return new MyViewHolder(ItemTreandingnearyouBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NewSeasonClass modelObject = list.get(position);

        holder.binding.imgProductImage.setImageResource(modelObject.getProductImage());
        holder.binding.txtProductName.setText(modelObject.getProductName());
        holder.binding.txtProductPrice.setText("Rs" + "" +modelObject.getProductPrice());
        holder.binding.txtProductPriceWithStrike.setText("Rs" + "" +modelObject.getProductStrikePrice());
        holder.binding.txtProductPriceWithStrike.setPaintFlags(holder.binding.txtProductPriceWithStrike.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        counter = Integer.valueOf(modelObject.getProductQuantity());
        productprice = Integer.valueOf(modelObject.getProductPrice());


        holder.binding.imgShowPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.binding.imgShowPlus.setVisibility(View.GONE);
                holder.binding.relShowPriceCount.setVisibility(View.VISIBLE);
            }
        });

        holder.binding.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter + 1;
                count = counter * Integer.valueOf(modelObject.getProductPrice());
                str_finalvalue = String.valueOf(count);
                holder.binding.txtProductPrice.setText("Rs" + "" +str_finalvalue);
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

                    holder.binding.txtProductPrice.setText("Rs"+ "" +str_finalvalue);
                    String temp1 = String.valueOf(counter);
                    holder.binding.txtCount.setText(temp1);
                }else if (counter > 1){
                    counter = counter - 1;
                    count = counter * Integer.valueOf(modelObject.getProductPrice());

                    str_finalvalue = String.valueOf(count);

                    holder.binding.txtProductPrice.setText("Rs" + "" +str_finalvalue);

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

        ItemTreandingnearyouBinding binding;

        public MyViewHolder(@NonNull ItemTreandingnearyouBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
