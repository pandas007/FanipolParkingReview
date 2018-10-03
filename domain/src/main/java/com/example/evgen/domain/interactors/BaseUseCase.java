package com.example.evgen.domain.interactors;

import com.example.evgen.domain.executor.PostExecutionThread;
import com.example.evgen.domain.executor.ThreadExecution;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase {

    protected Scheduler postExecutionThread;
    protected Scheduler threadExecution;

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
    }

    public BaseUseCase(PostExecutionThread postExecutionThread, ThreadExecution threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
