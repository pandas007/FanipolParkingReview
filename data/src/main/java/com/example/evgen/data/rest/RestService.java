package com.example.evgen.data.rest;

import android.util.Log;

import com.example.evgen.data.entity.Driver;
import com.example.evgen.domain.entity.DriverEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public Completable saveDriverTest(Driver driver){
       return restApi.saveDriverTest(driver);
    }
}
