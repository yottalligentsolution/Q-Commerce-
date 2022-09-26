package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.adapter.OrdersAdapter;
import com.yotta.qcommerce.activity.adapter.WishListAdapter;
import com.yotta.qcommerce.activity.model.OrdersClass;
import com.yotta.qcommerce.activity.model.WishListClass;
import com.yotta.qcommerce.databinding.ActivityOrderBinding;
import com.yotta.qcommerce.databinding.ActivityWishListBinding;

import java.util.ArrayList;
import java.util.List;

public class WishListActivity extends AppCompatActivity {

    ActivityWishListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWishListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setOrders();
    }

    private void setOrders() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        binding.rvOrders.setLayoutManager(layoutManager);
        List<WishListClass> list = new ArrayList<>();
        list.add(new WishListClass(R.drawable.demolaptop2,"SDFF65GG","32100"));
        list.add(new WishListClass(R.drawable.demolaptop1,"SDFF65GG","32101"));
        list.add(new WishListClass(R.drawable.demolaptop3,"SDFF65GG","32102"));
        list.add(new WishListClass(R.drawable.demolaptop2,"SDFF65GG","32103"));

        WishListAdapter wishListAdapter = new WishListAdapter(this ,list);
        binding.rvOrders.setAdapter(wishListAdapter);

    }
}