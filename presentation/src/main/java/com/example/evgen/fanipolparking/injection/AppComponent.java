package com.example.evgen.fanipolparking.injection;

import com.example.evgen.fanipolparking.DriverFragment;
import com.example.evgen.fanipolparking.presentation.screens.DriverViewModel;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component (modules = {AppModule.class})
public interface AppComponent {

    void inject(DriverViewModel driverViewModel);
    void inject(DriverFragment driverFragment);
}
