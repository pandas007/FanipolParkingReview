package com.example.evgen.fanipolparking.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.databinding.AdminCarListScreenBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmActivity;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminCarListViewModel;

import butterknife.OnClick;


public class AdminCarListActivity extends BaseMvvmActivity<AdminCarListScreenBinding, AdminCarListViewModel>{

    @Override
    public int provideLayoutId() {
        return R.layout.admin_car_list_screen;
    }

    @Override
    public AdminCarListViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(AdminCarListViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.carListAdapter.setCarList(viewModel.carList);
    }

    @OnClick(R.id.addCarButton)
    void onClickedAddCarButton(){
        startActivity(new Intent(this, AdminAddCarActivity.class));
    }
}
