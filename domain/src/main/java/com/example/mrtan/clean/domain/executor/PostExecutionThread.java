package com.example.mrtan.clean.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by tanxiaolong on 17/3/6.
 */

public interface PostExecutionThread {
    Scheduler scheduler();
}
