package com.example.evgen.fanipolparking.presentation.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel extends ViewModel {

    //warningNoInternetTextView. Used by NetworkReceiver
    public final ObservableBoolean isOnline = new ObservableBoolean();

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
