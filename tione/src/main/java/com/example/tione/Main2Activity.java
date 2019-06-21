package com.example.tione;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<Integer> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        Intent intent = getIntent();
        final ArrayList<String> name = (ArrayList<String>) intent.getSerializableExtra("name");

        arr = new ArrayList<>();
        mVp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return name.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view==o;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                View inflate = LayoutInflater.from(Main2Activity.this).inflate(R.layout.itemone, null);
                TextView names = inflate.findViewById(R.id.names);
                TextView tv = inflate.findViewById(R.id.tv);


                
                return super.instantiateItem(container, position);
            }
        });

    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
