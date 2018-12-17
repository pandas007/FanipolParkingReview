package com.example.evgen.fanipolparking.presentation.screens.viewmodels;

import android.databinding.ObservableField;
import android.util.Log;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.interactors.DateParser;
import com.example.evgen.domain.interactors.SaveNewDriverUseCase;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;

import java.text.ParseException;

import javax.inject.Inject;

import io.reactivex.functions.Action;


public class AdminAddCarViewModel extends BaseViewModel {

    public final ObservableField<String> editCarNumber = new ObservableField<>("");
    public final ObservableField<String> editCarModel = new ObservableField<>("");
    public final ObservableField<String> editPhone = new ObservableField<>("");
    public final ObservableField<String> editPayDay = new ObservableField<>("");

    //Double click confirm
    public boolean isSaveConfirm = false;

    private DriverEntity driver;

    @Inject
    public SaveNewDriverUseCase saveNewDriverUseCase;
    @Inject
    public DateParser dateParser;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }


    public void saveNewDriver(){
        driver = createDriver();
        if (driver != null && !isSaveConfirm) {
            saveNewDriverUseCase.saveDriver(driver)
                    .subscribe(new Action() {
                        @Override
                        public void run() throws Exception {
                            isSaveConfirm = true;
                        }
                    });
        }
    }
    private DriverEntity createDriver(){
        try {
            return new DriverEntity(editCarNumber.get(),
                   editCarModel.get(), editPhone.get(), getPayDayMillis(editPayDay.get()));
        } catch (ParseException e) {
            Log.e(this.toString(), e.getMessage());
            editPayDay.set("Ошибка ввода: число.месяц.год");
            return null;
        }
    }

    private long getPayDayMillis(String payDayString) throws ParseException{
            return dateParser.textToDate(editPayDay.get()).getTime();
    }
}
