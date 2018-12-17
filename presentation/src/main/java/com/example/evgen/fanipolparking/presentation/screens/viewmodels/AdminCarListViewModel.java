package com.example.evgen.fanipolparking.presentation.screens.viewmodels;

import android.databinding.ObservableBoolean;
import android.util.Log;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.interactors.GetDriversUseCase;
import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.adapters.CarListAdapter;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class AdminCarListViewModel extends BaseViewModel {

    public List<DriverEntity> carList = new ArrayList<>();
    public CarListAdapter carListAdapter = new CarListAdapter(R.layout.admin_car_list_item, this);
    public ObservableBoolean isLoaded = new ObservableBoolean(true);

    @Inject
    public GetDriversUseCase getDriversUseCase;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    private void getCars(){
        getDriversUseCase.getDrivers().subscribe(new Observer<List<DriverEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
                isLoaded.set(false);
            }

            @Override
            public void onNext(List<DriverEntity> driverEntities) {
                carList.addAll(driverEntities);
                carListAdapter.setCarList(driverEntities);
                isLoaded.set(true);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(this.toString(), e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getCars();
        carListAdapter.notifyDataSetChanged();
    }

    public DriverEntity getDriverAtPos(Integer index){
        if (carList != null && index != null && carList.size() > index){
            return carList.get(index);
        }
        return null;
    }

}
