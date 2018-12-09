package com.example.evgen.fanipolparking.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;

import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.databinding.AdminAddCarScreenBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmActivity;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminAddCarViewModel;

public class AdminAddCarActivity extends BaseMvvmActivity<AdminAddCarScreenBinding, AdminAddCarViewModel> {
    @Override
    public int provideLayoutId() {
        return R.layout.admin_add_car_screen;
    }

    @Override
    public AdminAddCarViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(AdminAddCarViewModel.class);
    }

}
