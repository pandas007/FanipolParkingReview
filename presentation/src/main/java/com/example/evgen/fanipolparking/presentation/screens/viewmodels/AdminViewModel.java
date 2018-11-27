package com.example.evgen.fanipolparking.presentation.screens.viewmodels;

import android.databinding.ObservableField;

import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;


public class AdminViewModel extends BaseViewModel {

    public ObservableField<String> password = new ObservableField<>("");

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }
}
