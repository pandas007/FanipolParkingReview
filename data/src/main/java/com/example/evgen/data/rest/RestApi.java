package com.example.evgen.data.rest;

import com.example.evgen.data.entity.Driver;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface RestApi {

    @GET ("data/Cars?pageSize=100")
    Observable<List<Driver>> loadDrivers();

    @POST("data/Cars")
    @Headers({"Content-Type: application/json"})
    Completable saveDriver(@Body Driver driver);

    @DELETE("data/Cars/{objectId}")
    Completable removeDriver(@Path("objectId") String objectId);

    @PUT("data/Cars/{objectId}")
    @Headers({"Content-Type: application/json"})
    Completable editDriver(@Path("objectId") String objectId, @Body Driver driver);
}
