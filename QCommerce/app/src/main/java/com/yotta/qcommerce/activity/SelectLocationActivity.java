package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.adapter.LocationAdapter;
import com.yotta.qcommerce.activity.adapter.SelectAddressAdapter;
import com.yotta.qcommerce.activity.model.LocationClass;
import com.yotta.qcommerce.activity.model.SelectAddressClass;
import com.yotta.qcommerce.databinding.ActivityMainBinding;
import com.yotta.qcommerce.databinding.ActivitySelectLocationBinding;

import java.util.ArrayList;
import java.util.List;

public class SelectLocationActivity extends AppCompatActivity implements SelectAddressAdapter.addAddressClick {

    ActivitySelectLocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        selectAddress();

        binding.txtAddNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectLocationActivity.this,EditAddressActivity.class);
                intent.putExtra("from_addNewAddress","1");
                startActivity(intent);
            }
        });
    }

    private void selectAddress() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        binding.rvSelectAddress.setLayoutManager(layoutManager);
        List<SelectAddressClass> list = new ArrayList<>();
        list.add(new SelectAddressClass("Demo Test Example","Pune Maharashtra India 411041","9975633311"));
        list.add(new SelectAddressClass("Demo Test Example","Pune Maharashtra India 411041","9975633311"));
        list.add(new SelectAddressClass("Demo Test Example","Pune Maharashtra India 411041","9975633311"));

        SelectAddressAdapter selectAddressAdapter = new SelectAddressAdapter(this ,list, this);
        binding.rvSelectAddress.setAdapter(selectAddressAdapter);

    }

    @Override
    public void onAddressClick(String address, String location) {

    }
}