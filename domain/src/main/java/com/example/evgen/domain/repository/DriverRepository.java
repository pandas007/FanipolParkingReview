package com.example.evgen.domain.repository;

import com.example.evgen.domain.entity.DriverEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;


public interface DriverRepository {

    Observable<List<DriverEntity>> get();
    Completable save();
}
