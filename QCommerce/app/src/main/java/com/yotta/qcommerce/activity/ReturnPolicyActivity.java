package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yotta.qcommerce.databinding.ActivityReturnPolicyBinding;
import com.yotta.qcommerce.databinding.ActivityTermsAndConditionBinding;

public class ReturnPolicyActivity extends AppCompatActivity {

    ActivityReturnPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReturnPolicyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}