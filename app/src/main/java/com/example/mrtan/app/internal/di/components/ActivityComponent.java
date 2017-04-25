package com.example.mrtan.app.internal.di.components;

import android.app.Activity;
import com.example.mrtan.app.internal.di.ScopeActivity;
import com.example.mrtan.app.internal.di.modules.ActivityModule;
import dagger.Component;

/**
 * @author mrtan 17-3-25
 */
@ScopeActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class})
public interface ActivityComponent {
  Activity activity();
}
