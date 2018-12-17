package com.example.evgen.fanipolparking.injection;

import android.content.Context;

import com.example.evgen.data.BuildConfig;
import com.example.evgen.data.repository.DriverRepositoryImpl;
import com.example.evgen.data.rest.RestApi;
import com.example.evgen.data.rest.RestService;
import com.example.evgen.domain.executor.PostExecutionThread;
import com.example.evgen.domain.interactors.DateParser;
import com.example.evgen.domain.repository.DriverRepository;
import com.example.evgen.fanipolparking.executor.UIThread;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

    Context context;

    public AppModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext(){
        return context;
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit){
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .build();
    }


    @Provides
    @Singleton
    public OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread(){
        return new UIThread();
    }

    @Provides
    @Singleton
    public DriverRepository getDriverRepository(Context context, RestService restService){
        return new DriverRepositoryImpl(context, restService);
    }

    @Provides
    @Singleton
    public DateParser getDateParser(){
        return new DateParser();
    }
}
