package com.example.evgen.fanipolparking.presentation.screens.viewmodels;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.interactors.DateParser;

import com.example.evgen.domain.interactors.EditDriverUseCase;
import com.example.evgen.domain.interactors.RemoveDriverUseCase;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;

import java.util.Date;

import javax.inject.Inject;


public class AdminEditCarViewModel extends BaseViewModel{

    public final ObservableField<String> createdDay = new ObservableField<>("");
    public final ObservableField<String> payDay = new ObservableField<>("");
    public final ObservableField<String> carNumber = new ObservableField<>("");
    public final ObservableField<String> carModel = new ObservableField<>("");
    public final ObservableField<String> phone = new ObservableField<>("");
    public final ObservableField<String> extendDays = new ObservableField<>("");

    public final ObservableBoolean isExtendButtonPressed = new ObservableBoolean(false);


    public DriverEntity driverEntity;
    //DataBinding provides driverEntity from admin_car_list_item.xml by setOnClick()
    // with Intent.getSerializableExtra in AdminEditCarActivity

    @Inject
    public DateParser dateParser;
    @Inject
    public RemoveDriverUseCase removeDriverUseCase;
    @Inject
    public EditDriverUseCase editDriverUseCase;



    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        initFields(driverEntity);
    }

    public void deleteDriver(){
        removeDriverUseCase.removeDriver(driverEntity.getObjectId())
                .subscribe();
    }

    public void editDriver(){
        editDriverEntity(driverEntity);
        editDriverUseCase.editDriver(driverEntity)
                .subscribe();
    }

    /**
     * Add extendDays to payDay and editDriver();
     */
    public void extendDaysToPayDay(){
        if (!extendDays.get().equals("")) {
            long extendDaysCount = Long.valueOf(extendDays.get());
            long millis = driverEntity.getPayDayTime() + dateParser.daysToMillis(extendDaysCount);
            driverEntity.setPayDayTime(millis);
            editDriver();
            extendDays.set("");
        }
    }

    private void initFields(DriverEntity driverEntity){
        carNumber.set(driverEntity.getNumber());
        carModel.set(driverEntity.getCar());
        phone.set(driverEntity.getPhone());
        createdDay.set(dateParser.dateToText(new Date(driverEntity.getCreatedTime())));
        payDay.set(dateParser.dateToText(new Date(driverEntity.getPayDayTime())));
    }

    /**
     * fill current DriverEntity() for @PUT request
     * @param driverEntity
     */
    private void editDriverEntity(DriverEntity driverEntity){
        driverEntity.setNumber(carNumber.get());
        driverEntity.setCar(carModel.get());
        driverEntity.setPhone(phone.get());
    }

}
