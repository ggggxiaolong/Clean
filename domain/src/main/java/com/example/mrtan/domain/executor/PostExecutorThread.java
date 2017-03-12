package com.example.mrtan.domain.executor;

import io.reactivex.Scheduler;

/**
 * @author mrtan 17-3-12
 */

public interface PostExecutorThread {
  Scheduler scheduler();
}
