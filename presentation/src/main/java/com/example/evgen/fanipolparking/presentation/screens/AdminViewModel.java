package com.example.evgen.fanipolparking.presentation.screens;

import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;


public class AdminViewModel extends BaseViewModel {
    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }
}
