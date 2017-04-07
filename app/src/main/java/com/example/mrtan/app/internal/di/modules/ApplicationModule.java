package com.example.mrtan.app.internal.di.modules;

import android.app.Application;
import android.content.Context;
import com.example.mrtan.app.UIThread;
import com.example.mrtan.data.cache.UserCache;
import com.example.mrtan.data.cache.UserCacheImpl;
import com.example.mrtan.data.executor.JobExecutor;
import com.example.mrtan.data.repository.UserDataRepository;
import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import com.example.mrtan.domain.repository.UserRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author mrtan 17-3-25
 */
@Module public class ApplicationModule {
  final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides @Singleton Context provideContext() {
    return mApplication;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutorThread providePostExecutor(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository){
    return userDataRepository;
  }
}
