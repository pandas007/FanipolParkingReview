package com.example.evgen.fanipolparking.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.databinding.DriverInfoScreenBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmActivity;


public class DriverInfoScreen extends BaseMvvmActivity<DriverInfoScreenBinding, DriverViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.driver_info_screen;
    }

    @Override
    public DriverViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(DriverViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.carModel.set(getIntent().getStringExtra("Car"));
    }
}
