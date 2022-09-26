package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.databinding.ActivityChangeLanguageBinding;
import com.yotta.qcommerce.databinding.ActivityProfileBinding;

public class ChangeLanguageActivity extends AppCompatActivity {

    ActivityChangeLanguageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeLanguageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}