package com.yotta.qcommerce.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.fragments.CartFragment;
import com.yotta.qcommerce.activity.fragments.CategoriesFragment;
import com.yotta.qcommerce.activity.fragments.HistoryFragment;
import com.yotta.qcommerce.activity.fragments.HomeFragment;
import com.yotta.qcommerce.activity.fragments.ProfileFragment;
import com.yotta.qcommerce.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    Dialog dialog;

    private int[] tabIcon = {
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_category_24,
            R.drawable.ic_baseline_shopping_cart_24,
            R.drawable.ic_baseline_person_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setupViewPager(binding.viewpager);
        binding.viewpager.setCurrentItem(3);
        binding.viewpager.beginFakeDrag();
        binding.tabs.setupWithViewPager(binding.viewpager);
        setupTabIcons();

        binding.tabs.getTabAt(0).select();
        binding.tabs.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(binding.viewpager) {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        //tab.view.setBackground(getResources().getDrawable(R.drawable.text_bluebox));
                        int tabIconColor = ContextCompat.getColor(HomeActivity.this, R.color.faint_pink);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        //tab.view.setBackground(null);
                        int tabIconColor = ContextCompat.getColor(HomeActivity.this, R.color.black);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        int tabIconColor = ContextCompat.getColor(HomeActivity.this, R.color.faint_pink);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }
                });


    }

    private void setupTabIcons() {
        binding.tabs.getTabAt(0).setIcon(tabIcon[0]);
        binding.tabs.getTabAt(1).setIcon(tabIcon[1]);
        binding.tabs.getTabAt(2).setIcon(tabIcon[2]);
        binding.tabs.getTabAt(3).setIcon(tabIcon[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), getString(R.string.home));
        adapter.addFragment(new CategoriesFragment(), getString(R.string.categories));
        adapter.addFragment(new CartFragment(), getString(R.string.cart));
        adapter.addFragment(new ProfileFragment(), getString(R.string.profile));
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
    }



    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.exit_dialog);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        lp.windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setAttributes(lp);
        dialog.show();

        TextView exitBtn = dialog.findViewById(R.id.exitButton);
        TextView cnlBtn = dialog.findViewById(R.id.cancelButton);
        exitBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               /* SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("logged", "logged");
                editor.apply();*/
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        cnlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    @Override
    public void finish() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}