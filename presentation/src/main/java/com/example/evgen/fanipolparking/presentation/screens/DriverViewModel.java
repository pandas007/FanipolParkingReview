package com.example.evgen.fanipolparking.presentation.screens;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.evgen.domain.interactors.FindDriverByNumberUseCase;
import com.example.evgen.fanipolparking.NetworkReceiver;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;

import javax.inject.Inject;



public class DriverViewModel extends BaseViewModel {

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    public FindDriverByNumberUseCase findDriverUseCase;

    public DriverViewModel(){

    }
}
