package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.databinding.ActivityWishListBinding;
import com.yotta.qcommerce.databinding.ActivityWriteForUsBinding;

public class WriteForUsActivity extends AppCompatActivity {

    ActivityWriteForUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWriteForUsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



    }
}