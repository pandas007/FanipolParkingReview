package com.example.evgen.fanipolparking.presentation.screens;

import android.databinding.ObservableField;

import com.example.evgen.domain.interactors.FindDriverByNumberUseCase;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;

import javax.inject.Inject;



public class DriverViewModel extends BaseViewModel {
    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

//    @Inject
//    public FindDriverByNumberUseCase findDriverUseCase;

    public ObservableField<String> carModel = new ObservableField<>("");
    public ObservableField<String> carNumber = new ObservableField<>("");


    public DriverViewModel(){

    }
}
