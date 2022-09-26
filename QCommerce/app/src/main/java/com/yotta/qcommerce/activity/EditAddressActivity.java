package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.databinding.ActivityEditaddressBinding;
import com.yotta.qcommerce.databinding.ActivitySelectLocationBinding;

public class EditAddressActivity extends AppCompatActivity {

    ActivityEditaddressBinding binding;
    String[] state = { "Maharashtra", "Goa", "J&K", "Madhya Pradesh", "Assam", "Uttar Pradesh" };
    String[] country = { "India", "US", "UK", "Russia", "Japan", "Dubai" };
    String[] addressType = { "Home 9 am -6 pm", "Company 9 am - 6 pm"};
    String addNewAddress ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditaddressBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            addNewAddress = extras.getString("from_addNewAddress");
        }

        if (addNewAddress.equalsIgnoreCase("1"))
        {
            binding.dashboard.setText(getString(R.string.addnewaddress));
        }else if (addNewAddress.equalsIgnoreCase("2"))
        {
            binding.dashboard.setText(getString(R.string.editaddress));
        }


        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, state);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinState.setAdapter(ad);

        ArrayAdapter ad1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinCountry.setAdapter(ad1);

        ArrayAdapter ad2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, addressType);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinAddressType.setAdapter(ad2);
    }
}