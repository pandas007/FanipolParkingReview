package com.example.evgen.domain.interactors;


import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.executor.PostExecutionThread;
import com.example.evgen.domain.repository.DriverRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class EditDriverUseCase extends BaseUseCase {

    private DriverRepository driverRepository;

    @Inject
    public EditDriverUseCase(PostExecutionThread postExecutionThread, DriverRepository driverRepository) {
        super(postExecutionThread);
        this.driverRepository = driverRepository;
    }

    public Completable editDriver(DriverEntity driverEntity){
        return driverRepository.edit(driverEntity)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
