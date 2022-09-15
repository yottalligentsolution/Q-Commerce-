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

import com.yotta.qcommerce.activity.model.ExploreByCategoriesClass;
import com.yotta.qcommerce.activity.model.TrendingNearYouClass;
import com.yotta.qcommerce.databinding.ItemExpolrebycategoriesBinding;
import com.yotta.qcommerce.databinding.ItemTreandingnearyouBinding;

import java.util.List;

public class ExploreByCategoriesAdapter extends RecyclerView.Adapter<ExploreByCategoriesAdapter.MyViewHolder> {

    List<ExploreByCategoriesClass> list;
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


    public ExploreByCategoriesAdapter(Context context , List<ExploreByCategoriesClass> list) {
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

        return new MyViewHolder(ItemExpolrebycategoriesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ExploreByCategoriesClass modelObject = list.get(position);

        holder.binding.imgProductImage.setImageResource(modelObject.getCategoriesImages());
        holder.binding.txtProductName.setText(modelObject.getCategoriesName());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemExpolrebycategoriesBinding binding;

        public MyViewHolder(@NonNull ItemExpolrebycategoriesBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
