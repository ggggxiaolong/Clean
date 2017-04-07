package com.example.mrtan.app;

import com.example.mrtan.domain.executor.PostExecutorThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author mrtan 17-3-18
 */
@Singleton public class UIThread implements PostExecutorThread {
  @Inject public UIThread() {
  }

  @Override public Scheduler scheduler() {
    return AndroidSchedulers.mainThread();
  }
}
