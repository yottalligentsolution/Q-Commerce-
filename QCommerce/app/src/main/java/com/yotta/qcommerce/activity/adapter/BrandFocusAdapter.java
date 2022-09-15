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
import com.yotta.qcommerce.databinding.ItemBrandfocusBinding;

import java.util.List;

public class BrandFocusAdapter extends RecyclerView.Adapter<BrandFocusAdapter.MyViewHolder> {

    List<BrandFocusClass> list;
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


    public BrandFocusAdapter(Context context , List<BrandFocusClass> list) {
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

        return new MyViewHolder(ItemBrandfocusBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        BrandFocusClass modelObject = list.get(position);

        holder.binding.imgProductLogo.setImageResource(modelObject.getCompanyLogo());
        holder.binding.imgProduct.setImageResource(modelObject.getCompanyProduct());
        holder.binding.txtDiscount.setText(modelObject.getOff());

        holder.binding.relMainLayout.setBackgroundResource(R.drawable.my_gradient_brandfocus);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemBrandfocusBinding binding;

        public MyViewHolder(@NonNull ItemBrandfocusBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }
}
