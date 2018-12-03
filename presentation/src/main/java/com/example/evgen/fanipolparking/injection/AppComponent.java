package com.example.evgen.fanipolparking.injection;

import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminAddCarViewModel;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminCarListViewModel;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminViewModel;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.DriverViewModel;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component (modules = {AppModule.class})
public interface AppComponent {

    void inject(DriverViewModel driverViewModel);
    void inject(AdminViewModel adminViewModel);
    void inject(AdminCarListViewModel adminCarListViewModel);
    void inject(AdminAddCarViewModel adminAddCarViewModel);
}
