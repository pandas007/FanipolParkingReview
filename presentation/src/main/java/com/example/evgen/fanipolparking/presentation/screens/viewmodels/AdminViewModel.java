package com.example.evgen.fanipolparking.presentation.screens.viewmodels;

import android.databinding.ObservableField;

import com.example.evgen.data.BuildConfig;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;

import io.reactivex.subjects.CompletableSubject;



public class AdminViewModel extends BaseViewModel {

    public final ObservableField<String> password = new ObservableField<>("");
    public final ObservableField<Boolean> isRightPassword = new ObservableField<>(true);

    public CompletableSubject completable = CompletableSubject.create();// FIXME Не лучшее решение. Будет время - нужно поменять

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public void onClickEnterAdmin(){
        if (password.get().equals(BuildConfig.ADMIN_PASSWORD)){
            isRightPassword.set(true);
            completable.onComplete();
        }else{
            isRightPassword.set(false);
        }
    }
}
