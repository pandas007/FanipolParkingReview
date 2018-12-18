package com.example.evgen.fanipolparking.presentation.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.evgen.fanipolparking.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StartActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        ButterKnife.bind(this);

        viewPager.setAdapter(new DriverAndAdminPageAdapter(getSupportFragmentManager(), StartActivity.this));
        tabLayout.setupWithViewPager(viewPager);
    }
}
