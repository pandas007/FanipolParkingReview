package com.example.evgen.fanipolparking.presentation.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseViewModel() {
        createInject();
    }

    public void onStart(){
    }

    public void onStop(){
    }

    public void onResume(){
    }

    public void onPause(){
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

    /**
     * Helps to dont forget about dagger injection App.getAppComponent().inject()
     */
    public abstract void createInject();
}
