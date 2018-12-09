package com.example.evgen.fanipolparking.presentation.screens.viewmodels;

import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;


public class AdminAddCarViewModel extends BaseViewModel {
    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

}
