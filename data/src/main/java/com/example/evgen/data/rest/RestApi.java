package com.example.evgen.data.rest;

import com.example.evgen.data.entity.Driver;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface RestApi {

    @GET ("data/Cars?pageSize=100")
    Observable<List<Driver>> loadDrivers();

    @POST("data/Cars")
    @Headers({"Content-Type: application/json"})
    Completable saveDriverTest(@Body Driver driver);
}
