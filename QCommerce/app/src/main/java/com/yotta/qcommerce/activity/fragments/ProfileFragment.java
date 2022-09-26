package com.yotta.qcommerce.activity.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.ChangeLanguageActivity;
import com.yotta.qcommerce.activity.FaqActivity;
import com.yotta.qcommerce.activity.OrderActivity;
import com.yotta.qcommerce.activity.ProfileActivity;
import com.yotta.qcommerce.activity.ReturnPolicyActivity;
import com.yotta.qcommerce.activity.SelectLocationActivity;
import com.yotta.qcommerce.activity.TermsAndConditionActivity;
import com.yotta.qcommerce.activity.WishListActivity;
import com.yotta.qcommerce.activity.WriteForUsActivity;
import com.yotta.qcommerce.databinding.FragmentHomeBinding;
import com.yotta.qcommerce.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater,container,false);

        binding.layOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        binding.layAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SelectLocationActivity.class);
                startActivity(intent);
            }
        });

        binding.layMyFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FaqActivity.class);
                startActivity(intent);
            }
        });

        binding.layWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WishListActivity.class);
                startActivity(intent);
            }
        });

        binding.layProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        binding.layChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChangeLanguageActivity.class);
                startActivity(intent);
            }
        });

        binding.layTermsAndCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TermsAndConditionActivity.class);
                startActivity(intent);
            }
        });

        binding.layMyReturnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReturnPolicyActivity.class);
                startActivity(intent);
            }
        });

        binding.layMyReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WriteForUsActivity.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}