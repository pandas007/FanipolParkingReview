package com.example.evgen.fanipolparking.presentation.screens.viewmodels;

import android.arch.lifecycle.LiveData;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.interactors.FindDriverByNumberUseCase;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmFragment;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;
import com.example.evgen.fanipolparking.presentation.screens.DriverDialog;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


public class DriverViewModel extends BaseViewModel {

    public final ObservableField<String> editText1 = new ObservableField<>("");
    public final ObservableField<String> editText2 = new ObservableField<>("");
    public final ObservableField<String> editText3 = new ObservableField<>("");
    public final ObservableBoolean isFindCar = new ObservableBoolean(true);

    public Subject<DriverDialog> dialogSubject = PublishSubject.create();

    @Inject
    public FindDriverByNumberUseCase findDriverUseCase;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    private String combineFullNumber(){
        StringBuilder sb = new StringBuilder();
        sb.append(editText1.get())
                .append(editText2.get())
                .append(editText3.get());
        return sb.toString().toLowerCase();
    }

    public void onClickCheckButton(){
        findDriverUseCase.findDriver(combineFullNumber())
                .subscribe(new Observer<DriverEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(DriverEntity driverEntity) {
                        isFindCar.set(true);
                        DriverDialog driverDialog = new DriverDialog();

                        driverDialog.setCar(driverEntity.getCar());
                        driverDialog.setNumber(driverEntity.getNumber());

                        dialogSubject.onNext(driverDialog);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isFindCar.set(false);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

}
