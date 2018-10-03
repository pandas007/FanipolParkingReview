package com.example.evgen.domain.executor;

import io.reactivex.Scheduler;


public interface PostExecutionThread {
    Scheduler getScheduler();
}
