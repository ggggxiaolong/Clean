package com.example.mrtan.app.view.base;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.app.Fragment;
import com.example.mrtan.app.App;
import com.example.mrtan.app.internal.di.components.ApplicationComponent;
import com.example.mrtan.app.internal.di.modules.ActivityModule;
import com.example.mrtan.app.navigation.Navigator;
import javax.inject.Inject;

/**
 * @author mrtan 17-3-25
 */

public abstract class BaseActivity extends Activity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  
  protected ApplicationComponent getApplicationComponent(){
    return ((App)getApplication()).getComponent();
  }

  protected ActivityModule provideActivityModule(){
    return new ActivityModule(this);
  }

  protected void addFragment(@IdRes int containId, Fragment fragment){
    final FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.add(containId, fragment);
    transaction.commit();
  }
}
