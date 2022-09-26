package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.adapter.OrdersAdapter;
import com.yotta.qcommerce.activity.adapter.SelectAddressAdapter;
import com.yotta.qcommerce.activity.model.OrdersClass;
import com.yotta.qcommerce.activity.model.SelectAddressClass;
import com.yotta.qcommerce.databinding.ActivityHomeBinding;
import com.yotta.qcommerce.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setOrders();
    }

    private void setOrders() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        binding.rvOrders.setLayoutManager(layoutManager);
        List<OrdersClass> list = new ArrayList<>();
        list.add(new OrdersClass("Nivea body lotion...","SDFF65GG","15/09/2022 at 11:55 pm"));
        list.add(new OrdersClass("Nivea body lotion...","SDFF65GG","15/09/2022 at 11:55 pm"));
        list.add(new OrdersClass("Nivea body lotion...","SDFF65GG","15/09/2022 at 11:55 pm"));

        OrdersAdapter ordersAdapter = new OrdersAdapter(this ,list);
        binding.rvOrders.setAdapter(ordersAdapter);

    }

}