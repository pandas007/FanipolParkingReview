package com.example.evgen.fanipolparking.presentation.screens.viewmodels;

import android.util.Log;

import com.android.databinding.library.baseAdapters.BR;
import com.example.evgen.data.entity.Driver;
import com.example.evgen.data.rest.RestApi;
import com.example.evgen.data.rest.RestService;
import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.interactors.GetDriversUseCase;
import com.example.evgen.domain.interactors.SaveNewDriverUseCase;
import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.adapters.CarListAdapter;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class AdminCarListViewModel extends BaseViewModel {

    public List<DriverEntity> carList = new ArrayList<>();
    public CarListAdapter carListAdapter = new CarListAdapter(R.layout.admin_car_list_item, this);

    @Inject
    public GetDriversUseCase getDriversUseCase;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public AdminCarListViewModel() {
        getCars();
    }

    private void getCars(){
        getDriversUseCase.getDrivers().subscribe(new Consumer<List<DriverEntity>>() {
            @Override
            public void accept(List<DriverEntity> driverEntities) throws Exception {
                Log.e("getCars", String.valueOf(driverEntities.size()));
                carList.addAll(driverEntities);
                carListAdapter.notifyDataSetChanged();
            }
        });
    }

    public DriverEntity getDriverAtPos(Integer index){
        if (carList != null && index != null && carList.size() > index){
            return carList.get(index);
        }
        return null;
    }

}
