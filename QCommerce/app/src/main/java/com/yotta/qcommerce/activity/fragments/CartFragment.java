package com.yotta.qcommerce.activity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.adapter.CartItemAdapter;
import com.yotta.qcommerce.activity.adapter.MoveToCartAdapter;
import com.yotta.qcommerce.activity.adapter.TrendingNearYouAdapter;
import com.yotta.qcommerce.activity.model.CartItemClass;
import com.yotta.qcommerce.activity.model.MoveToCartItem;
import com.yotta.qcommerce.activity.model.TrendingNearYouClass;
import com.yotta.qcommerce.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(inflater,container,false);
        cartData();
        trendingNearYou();
        moveToCart();

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
}