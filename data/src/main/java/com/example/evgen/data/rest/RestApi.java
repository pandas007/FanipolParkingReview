package com.example.evgen.data.rest;

import com.example.evgen.data.entity.Driver;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface RestApi {

    @GET ("data/Cars")
    Observable<List<Driver>> loadDrivers();
}
