package com.example.evgen.data.repository;

import android.content.Context;

import com.example.evgen.data.entity.Driver;
import com.example.evgen.data.rest.RestService;
import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.repository.DriverRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class DriverRepositoryImpl implements DriverRepository {

    private Context context;
    private RestService restService;

    @Inject
    public DriverRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<List<DriverEntity>> get() {
        return restService.loadDrivers()
                .map(new Function<List<Driver>, List<DriverEntity>>() {
                    @Override
                    public List<DriverEntity> apply(List<Driver> drivers) throws Exception {

                        List<DriverEntity> driversList = new ArrayList<>();
                        for (Driver driver: drivers){
                            driversList.add(new DriverEntity(driver.getNumber(), driver.getCar()
                                    , driver.getPhone(), driver.getPayDate()));
                        }
                        return driversList;
                    }
                });
    }

    @Override
    public Completable save(DriverEntity driverEntity) {
        return restService.saveDriverTest(createAndFillDriver(driverEntity));
    }

    /**
     * Parse DriverEntity to Driver
     * @param driverEntity
     * @return new Driver()
     */
    private Driver createAndFillDriver(DriverEntity driverEntity){
        Driver driver = new Driver();
        driver.setNumber(driverEntity.getNumber());
        driver.setCar(driverEntity.getCar());
        driver.setPhone(driverEntity.getPhone());
        driver.setPayDate(driverEntity.getPayDayTime());
        return driver;
    }
}
