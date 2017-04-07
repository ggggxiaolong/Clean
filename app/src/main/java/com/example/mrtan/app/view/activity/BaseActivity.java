package com.example.mrtan.app.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.mrtan.app.internal.di.components.ApplicationComponent;
import com.example.mrtan.app.internal.di.modules.ActivityModule;
import com.example.mrtan.app.navigation.Navigator;
import javax.inject.Inject;

/**
 * @author mrtan 17-3-25
 */

public abstract class BaseActivity extends Activity {
  @Inject Navigator mNavigator;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
  }
  
  protected ApplicationComponent getApplicationComponent(){
    return null;// TODO: 17-3-25
  }

  protected ActivityModule provideActivityModule(){
    return new ActivityModule(this);
  }
}
