package com.example.evgen.fanipolparking.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;

import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.databinding.AdminAddCarScreenBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmActivity;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminAddCarViewModel;

import butterknife.OnClick;

public class AdminAddCarActivity extends BaseMvvmActivity<AdminAddCarScreenBinding, AdminAddCarViewModel> {

    private static final String FIRST_SAVE_CONFIRM = "Нажмите еще раз для подтверждения";
    private static final String SECOND_SAVE_CONFIRM = "Авто сохранено";

    @Override
    public int provideLayoutId() {
        return R.layout.admin_add_car_screen;
    }

    @Override
    public AdminAddCarViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(AdminAddCarViewModel.class);
    }

    @OnClick(R.id.saveCarButton)
    void onClickedSaveCarButton(){
        viewModel.saveNewDriver();
        if (viewModel.isSaveConfirm){
            Toast.makeText(this, SECOND_SAVE_CONFIRM, Toast.LENGTH_LONG).show();
            finish();
        }
        else Toast.makeText(this, FIRST_SAVE_CONFIRM, Toast.LENGTH_SHORT).show();

    }

}
