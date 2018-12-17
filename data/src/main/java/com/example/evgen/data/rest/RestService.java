package com.example.evgen.data.rest;

import com.example.evgen.data.entity.Driver;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi){
        this.restApi = restApi;
    }

    public Observable<List<Driver>> loadDrivers(){
       return restApi.loadDrivers();
    }

    public Completable saveDriver(Driver driver){
       return restApi.saveDriver(driver);
    }

    public Completable removeDriver(String objectId){
        return restApi.removeDriver(objectId);
    }

    public Completable editDriver(String objectId, Driver driver){
        return restApi.editDriver(objectId, driver);
    }
}
