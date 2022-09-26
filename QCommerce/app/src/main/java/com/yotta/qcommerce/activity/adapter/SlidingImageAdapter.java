package com.yotta.qcommerce.activity.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.yotta.qcommerce.R;
import com.yotta.qcommerce.activity.model.Item;

import java.util.List;

public class SlidingImageAdapter extends PagerAdapter {
    int[] image;
    LayoutInflater inflater;
    Context context;
    int position = 3;

    public SlidingImageAdapter(int[] image, Context context) {
        this.image = image;
        this.context = context;
    }


    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = inflater.inflate(R.layout.slidingimages_layout, container, false);
        img = (ImageView) itemview.findViewById(R.id.image);
        img.setImageResource(image[position]);

        //add item.xml to viewpager
        ((ViewPager) container).addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

    @Override
    public float getPageWidth(int position) {
        return .20f;   //it is used for set page widht of view pager
    }
}