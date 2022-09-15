package com.yotta.qcommerce.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.model.BannerClass;
import com.yotta.qcommerce.databinding.ItemBannerBinding;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.MyViewHolder> {

    List<BannerClass> list;

    public BannerAdapter(List<BannerClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(ItemBannerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BannerClass modelObject = list.get(position);
        holder.binding.bannerImage.setImageResource(modelObject.getBannerImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemBannerBinding binding;

        public MyViewHolder(@NonNull ItemBannerBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
