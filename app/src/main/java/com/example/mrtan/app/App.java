package com.example.mrtan.app;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author mrtan 17-3-18
 */

public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();
    initializeInjector();
    initializeLeakDetection();
  }

  private void initializeInjector() {
    // TODO: 17-3-18 dagger inject
  }

  private void initializeLeakDetection() {
    if (BuildConfig.DEBUG){
      LeakCanary.install(this);
    }
  }
}
