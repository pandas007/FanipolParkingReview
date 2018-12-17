package com.example.evgen.domain.interactors;


import com.example.evgen.domain.executor.PostExecutionThread;
import com.example.evgen.domain.repository.DriverRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class RemoveDriverUseCase extends BaseUseCase {

    private DriverRepository driverRepository;

    @Inject
    public RemoveDriverUseCase(PostExecutionThread postExecutionThread, DriverRepository driverRepository) {
        super(postExecutionThread);
        this.driverRepository = driverRepository;
    }

    public Completable removeDriver(String objectId){
        return driverRepository.remove(objectId)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
