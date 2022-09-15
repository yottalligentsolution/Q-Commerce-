package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.databinding.ActivityMainBinding;
import com.yotta.qcommerce.databinding.ActivitySplashScreenActvityBinding;

public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenActvityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySplashScreenActvityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_phoneNo = binding.editPhoneNumber.getText().toString();
                if (str_phoneNo.isEmpty())
                {
                    Toast.makeText(SplashScreenActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(SplashScreenActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}