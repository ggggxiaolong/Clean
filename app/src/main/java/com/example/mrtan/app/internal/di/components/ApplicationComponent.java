package com.example.mrtan.app.internal.di.components;

import android.content.Context;
import com.example.mrtan.app.internal.di.modules.ApplicationModule;
import com.example.mrtan.app.view.base.BaseActivity;
import com.example.mrtan.data.repository.DataModule;
import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import com.example.mrtan.domain.repository.UserRepository;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author mrtan 17-3-25
 */
@Singleton @Component(modules = {ApplicationModule.class, DataModule.class}) public interface ApplicationComponent {
  void inject (BaseActivity baseActivity);

  Context context();

  ThreadExecutor threadExecutor();

  PostExecutorThread postExecutorThread();

  UserRepository userRepository();
}
