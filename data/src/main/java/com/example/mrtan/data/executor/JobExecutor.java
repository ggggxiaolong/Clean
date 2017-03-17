package com.example.mrtan.data.executor;

import android.support.annotation.NonNull;
import com.example.mrtan.domain.executor.ThreadExecutor;

/**
 * @author mrtan 17-3-16
 */

public class JobExecutor implements ThreadExecutor {

  @Override public void execute(@NonNull Runnable command) {
    ExecutorManager.eventExecutor.execute(command);
  }
}
