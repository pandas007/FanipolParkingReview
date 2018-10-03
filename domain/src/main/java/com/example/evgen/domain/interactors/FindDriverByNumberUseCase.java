package com.example.evgen.domain.interactors;


import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.executor.PostExecutionThread;
import com.example.evgen.domain.repository.DriverRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class FindDriverByNumberUseCase extends BaseUseCase {

    private DriverRepository driverRepository;

    @Inject
    public FindDriverByNumberUseCase(PostExecutionThread postExecutionThread, DriverRepository driverRepository) {
        super(postExecutionThread);
        this.driverRepository = driverRepository;
    }

    public Observable<DriverEntity> findDriver(final String number) {

        return driverRepository.get()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread)
                .map(new Function<List<DriverEntity>, DriverEntity>() {
                    @Override
                    public DriverEntity apply(List<DriverEntity> driverEntities) throws Exception {
                        DriverEntity driver = null;
                        for (DriverEntity dr : driverEntities) {
                            if (dr.getNumber().toLowerCase().equals(number)) {
                                driver = dr;
                                break;
                            }
                        }
                        return driver;
                    }
                });
    }
}
