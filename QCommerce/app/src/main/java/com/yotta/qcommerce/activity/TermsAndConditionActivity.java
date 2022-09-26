package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.databinding.ActivityTermsAndConditionBinding;
import com.yotta.qcommerce.databinding.ActivityWishListBinding;

public class TermsAndConditionActivity extends AppCompatActivity {

    ActivityTermsAndConditionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsAndConditionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}