package com.yotta.qcommerce.activity.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.adapter.BannerAdapter;
import com.yotta.qcommerce.activity.adapter.BrandFocusAdapter;
import com.yotta.qcommerce.activity.adapter.ExploreByCategoriesAdapter;
import com.yotta.qcommerce.activity.adapter.LocationAdapter;
import com.yotta.qcommerce.activity.adapter.NewArrivalsAdapter;
import com.yotta.qcommerce.activity.adapter.NewSeasonAdapter;
import com.yotta.qcommerce.activity.adapter.RiceAndShineAdapter;
import com.yotta.qcommerce.activity.adapter.TrendingNearYouAdapter;
import com.yotta.qcommerce.activity.model.BannerClass;
import com.yotta.qcommerce.activity.model.BrandFocusClass;
import com.yotta.qcommerce.activity.model.ExploreByCategoriesClass;
import com.yotta.qcommerce.activity.model.LocationClass;
import com.yotta.qcommerce.activity.model.NewArrivalsClass;
import com.yotta.qcommerce.activity.model.NewSeasonClass;
import com.yotta.qcommerce.activity.model.RiceAndShineClass;
import com.yotta.qcommerce.activity.model.TrendingNearYouClass;
import com.yotta.qcommerce.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements LocationAdapter.addAddressClick{

    private FragmentHomeBinding binding;
    private Dialog dialog;
    RecyclerView rv_Location,rv_trendingNearYou;
    String get_Address = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        populateData();
        trendingNearYou();
        exploreByCategories();
        newArrivals();
        newSeason();
        newRiceAndShine();
        newBrandFocus();

        binding.userAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLocationDialog();
            }
        });

        binding.imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.linLocationSearchNotificationLayout.setVisibility(View.GONE);
                binding.relSearchLayout.setVisibility(View.VISIBLE);
            }
        });

        binding.imgSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.linLocationSearchNotificationLayout.setVisibility(View.VISIBLE);
                binding.relSearchLayout.setVisibility(View.GONE);
            }
        });

        return binding.getRoot();
    }

    private void populateData() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        binding.rvBanner.setLayoutManager(layoutManager);
        List<BannerClass> list = new ArrayList<>();
        list.add(new BannerClass(R.drawable.demo1));
        list.add(new BannerClass(R.drawable.demo2));
        list.add(new BannerClass(R.drawable.demo3));
        list.add(new BannerClass(R.drawable.demo1));


        BannerAdapter bannerAdapter = new BannerAdapter(list);
        binding.rvBanner.setAdapter(bannerAdapter);

        final int speedScroll = 1800;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if(count < list.size()){
                    binding.rvBanner.scrollToPosition(count++);
                    handler.postDelayed(this,speedScroll);
                }
            }
        };

        handler.postDelayed(runnable,speedScroll);

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

    private void exploreByCategories() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        binding.rvExploreByCategories.setLayoutManager(layoutManager);
        List<ExploreByCategoriesClass> list_trending = new ArrayList<>();
        list_trending.add(new ExploreByCategoriesClass("Fruits & Vegetables",R.drawable.demofruitsandvegitables));
        list_trending.add(new ExploreByCategoriesClass("Atta Rice, Oil & Dals",R.drawable.demoriceoil));
        list_trending.add(new ExploreByCategoriesClass("Fruits & Vegetables",R.drawable.demofruitsandvegitables));
        list_trending.add(new ExploreByCategoriesClass("Atta Rice, Oil & Dals",R.drawable.demoriceoil));

        ExploreByCategoriesAdapter trendingNearYouAdapter = new ExploreByCategoriesAdapter(getActivity(),list_trending);
        binding.rvExploreByCategories.setAdapter(trendingNearYouAdapter);

    }

    private void newArrivals() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        binding.rvNewArrivals.setLayoutManager(layoutManager);
        List<NewArrivalsClass> list_trending = new ArrayList<>();
        list_trending.add(new NewArrivalsClass(R.drawable.demolaptop1,"Hp Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new NewArrivalsClass(R.drawable.demolaptop2,"Dell Laptop 15' 512SSD","32500","32560","1"));
        list_trending.add(new NewArrivalsClass(R.drawable.demolaptop3,"MSI Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new NewArrivalsClass(R.drawable.demolaptop2,"Lenovo Laptop 15' 512SSD","32500","32560","1"));


        NewArrivalsAdapter trendingNearYouAdapter = new NewArrivalsAdapter(getActivity(),list_trending);
        binding.rvNewArrivals.setAdapter(trendingNearYouAdapter);

    }

    private void newSeason() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        binding.rvNewBestSeason.setLayoutManager(layoutManager);
        List<NewSeasonClass> list_trending = new ArrayList<>();
        list_trending.add(new NewSeasonClass(R.drawable.demolaptop1,"Hp Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new NewSeasonClass(R.drawable.demolaptop2,"Dell Laptop 15' 512SSD","32500","32560","1"));
        list_trending.add(new NewSeasonClass(R.drawable.demolaptop3,"MSI Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new NewSeasonClass(R.drawable.demolaptop2,"Lenovo Laptop 15' 512SSD","32500","32560","1"));


        NewSeasonAdapter newSeasonAdapter = new NewSeasonAdapter(getActivity(),list_trending);
        binding.rvNewBestSeason.setAdapter(newSeasonAdapter);

    }


    private void newRiceAndShine() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        binding.rvRiceAndShine.setLayoutManager(layoutManager);
        List<RiceAndShineClass> list_trending = new ArrayList<>();
        list_trending.add(new RiceAndShineClass(R.drawable.demolaptop1,"Hp Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new RiceAndShineClass(R.drawable.demolaptop2,"Dell Laptop 15' 512SSD","32500","32560","1"));
        list_trending.add(new RiceAndShineClass(R.drawable.demolaptop3,"MSI Laptop 14' 256SSD","32500","32560","1"));
        list_trending.add(new RiceAndShineClass(R.drawable.demolaptop2,"Lenovo Laptop 15' 512SSD","32500","32560","1"));


        RiceAndShineAdapter riceAndShineAdapter = new RiceAndShineAdapter(getActivity(),list_trending);
        binding.rvRiceAndShine.setAdapter(riceAndShineAdapter);

    }

    private void newBrandFocus() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        binding.rvBrandFocus.setLayoutManager(layoutManager);
        List<BrandFocusClass> list_trending = new ArrayList<>();
        list_trending.add(new BrandFocusClass(R.drawable.demopuma,R.drawable.demopumaproduct,"25% Off"));
        list_trending.add(new BrandFocusClass(R.drawable.demonastlelogo,R.drawable.demonastleproduct,"20% Off"));
        list_trending.add(new BrandFocusClass(R.drawable.demoparlelogo,R.drawable.demoparleproduct,"20% Off"));


        BrandFocusAdapter brandFocusAdapter = new BrandFocusAdapter(getActivity(),list_trending);
        binding.rvBrandFocus.setAdapter(brandFocusAdapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //binding.notesRecyclerView.setVisibility(View.VISIBLE);//this hide/show recyclerview visibility
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
        if (location.equalsIgnoreCase("1"))
        {
            dialog.dismiss();
        }else{
            dialog.show();
        }
    }
}