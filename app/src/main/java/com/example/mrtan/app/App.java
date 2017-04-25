package com.example.mrtan.app;

import android.app.Application;
import com.example.mrtan.app.internal.di.components.ApplicationComponent;
import com.example.mrtan.app.internal.di.components.DaggerApplicationComponent;
import com.example.mrtan.app.internal.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author mrtan 17-3-18
 */

public class App extends Application {

  ApplicationComponent mComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeInjector();
    initializeLeakDetection();
  }

  private void initializeInjector() {
    mComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  private void initializeLeakDetection() {
    if (BuildConfig.DEBUG) {
      LeakCanary.install(this);
    }
  }

  public ApplicationComponent getComponent(){
    return mComponent;
  }
}
