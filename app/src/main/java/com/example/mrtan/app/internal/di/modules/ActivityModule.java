package com.example.mrtan.app.internal.di.modules;

import android.app.Activity;
import com.example.mrtan.app.internal.di.ScopeActivity;
import dagger.Module;
import dagger.Provides;

/**
 * @author mrtan 17-3-25
 */
@Module
public class ActivityModule {
  final Activity mActivity;

  public ActivityModule(Activity activity) {
    mActivity = activity;
  }

  @ScopeActivity @Provides Activity provideActivity(){
    return mActivity;
  }
}
