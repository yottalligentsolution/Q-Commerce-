package com.yotta.qcommerce.activity.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.SelectLocationActivity;
import com.yotta.qcommerce.activity.adapter.CartItemAdapter;
import com.yotta.qcommerce.activity.adapter.LocationAdapter;
import com.yotta.qcommerce.activity.adapter.MoveToCartAdapter;
import com.yotta.qcommerce.activity.adapter.TrendingNearYouAdapter;
import com.yotta.qcommerce.activity.model.CartItemClass;
import com.yotta.qcommerce.activity.model.LocationClass;
import com.yotta.qcommerce.activity.model.MoveToCartItem;
import com.yotta.qcommerce.activity.model.TrendingNearYouClass;
import com.yotta.qcommerce.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment implements LocationAdapter.addAddressClick{

    private FragmentCartBinding binding;
    private Dialog dialog;
    RecyclerView rv_Location,rv_trendingNearYou;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(inflater,container,false);
        cartData();
        trendingNearYou();
        moveToCart();

        binding.txtProceedToDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SelectLocationActivity.class);
                startActivity(intent);
            }
        });

        binding.userAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLocationDialog();
            }
        });

        return binding.getRoot();
    }

    private void cartData() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        binding.rvCartItem.setLayoutManager(layoutManager);
        List<CartItemClass> list_trending = new ArrayList<>();
        list_trending.add(new CartItemClass(R.drawable.demolaptop1,"Hp Laptop 14' 256SSD","3250","32560","1"));
        list_trending.add(new CartItemClass(R.drawable.demolaptop2,"Dell Laptop 15' 512SSD","3200","32560","1"));
        list_trending.add(new CartItemClass(R.drawable.demolaptop3,"MSI Laptop 14' 256SSD","2500","32560","1"));
        list_trending.add(new CartItemClass(R.drawable.demolaptop2,"Lenovo Laptop 15' 512SSD","3250","32560","1"));


        CartItemAdapter cartItemAdapter = new CartItemAdapter(getActivity(),list_trending);
        binding.rvCartItem.setAdapter(cartItemAdapter);
    }

    private void trendingNearYou() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        binding.rvTrendingNearYou.setLayoutManager(layoutManager);
        List<TrendingNearYouClass> list_trending = new ArrayList<>();
        list_trending.add(new TrendingNearYouClass(R.drawable.demolaptop1,"Hp Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new TrendingNearYouClass(R.drawable.demolaptop2,"Dell Laptop 15' 512SSD","32500","32560","1"));
        list_trending.add(new TrendingNearYouClass(R.drawable.demolaptop3,"MSI Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new TrendingNearYouClass(R.drawable.demolaptop2,"Lenovo Laptop 15' 512SSD","32500","32560","1"));


        TrendingNearYouAdapter trendingNearYouAdapter = new TrendingNearYouAdapter(getActivity(),list_trending);
        binding.rvTrendingNearYou.setAdapter(trendingNearYouAdapter);

    }

    private void moveToCart() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        binding.rvSaveForLater.setLayoutManager(layoutManager);
        List<MoveToCartItem> list_trending = new ArrayList<>();
        list_trending.add(new MoveToCartItem(R.drawable.demolaptop1,"Hp Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new MoveToCartItem(R.drawable.demolaptop2,"Dell Laptop 15' 512SSD","32500","32560","1"));
        list_trending.add(new MoveToCartItem(R.drawable.demolaptop3,"MSI Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new MoveToCartItem(R.drawable.demolaptop2,"Lenovo Laptop 15' 512SSD","32500","32560","1"));


        MoveToCartAdapter moveToCartAdapter = new MoveToCartAdapter(getActivity(),list_trending);
        binding.rvSaveForLater.setAdapter(moveToCartAdapter);

    }

    private void showLocationDialog() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.location_dialog);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.BOTTOM;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();

        rv_Location = dialog.findViewById(R.id.rv_location);
        TextView txt_chooseLocation = dialog.findViewById(R.id.txt_addLocation);
        ImageView img_close = dialog.findViewById(R.id.img_close);

        LocationData();

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });


    }

    private void LocationData() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rv_Location.setLayoutManager(layoutManager);
        List<LocationClass> list = new ArrayList<>();
        list.add(new LocationClass("Pune Maharashtra India 411041"));
        list.add(new LocationClass("Mumbai Maharashtra India 411041"));
        list.add(new LocationClass("Solapur Maharashtra India 411041"));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity() ,list, this);
        rv_Location.setAdapter(locationAdapter);

    }

    @Override
    public void onAddressClick(String address, String location) {
        binding.userAddress.setText(address);
        if (location.equalsIgnoreCase("1")) {
            dialog.dismiss();
        } else {
            dialog.show();
        }
    }
}