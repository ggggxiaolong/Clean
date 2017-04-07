package com.example.mrtan.app.internal.di.components;

import com.example.mrtan.app.internal.di.ScopeActivity;
import com.example.mrtan.app.internal.di.modules.ActivityModule;
import com.example.mrtan.app.internal.di.modules.UserModule;
import dagger.Component;

/**
 * @author mrtan 17-3-25
 */
@ScopeActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, UserModule.class
}) public interface UserComponent {
  //void inject();
  // TODO: 17-3-25 not finish
}
