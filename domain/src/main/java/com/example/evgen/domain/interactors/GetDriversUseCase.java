package com.example.evgen.domain.interactors;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.executor.PostExecutionThread;
import com.example.evgen.domain.repository.DriverRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class GetDriversUseCase extends BaseUseCase {

    private DriverRepository driverRepository;

    @Inject
    public GetDriversUseCase(PostExecutionThread postExecutionThread, DriverRepository driverRepository) {
        super(postExecutionThread);
        this.driverRepository = driverRepository;
    }

    public Observable<List<DriverEntity>> getDrivers(){
        return driverRepository.get()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
