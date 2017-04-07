package com.example.mrtan.data.executor;

import android.support.annotation.NonNull;
import com.example.mrtan.domain.executor.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author mrtan 17-3-16
 */

@Singleton
public class JobExecutor implements ThreadExecutor {

  @Inject
  public JobExecutor(){}

  @Override public void execute(@NonNull Runnable command) {
    ExecutorManager.eventExecutor.execute(command);
  }
}
