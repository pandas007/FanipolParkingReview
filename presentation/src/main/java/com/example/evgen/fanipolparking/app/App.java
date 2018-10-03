package com.example.evgen.fanipolparking.app;

import android.app.Application;

import com.example.evgen.fanipolparking.injection.AppComponent;
import com.example.evgen.fanipolparking.injection.AppModule;
import com.example.evgen.fanipolparking.injection.DaggerAppComponent;


public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
