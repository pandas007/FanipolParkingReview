package com.example.evgen.fanipolparking.presentation.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.evgen.fanipolparking.R;


public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new DriverAndAdminPageAdapter(getSupportFragmentManager(), StartActivity.this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
