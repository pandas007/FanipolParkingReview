package com.example.evgen.data.rest;

import com.example.evgen.data.entity.Driver;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

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
}
