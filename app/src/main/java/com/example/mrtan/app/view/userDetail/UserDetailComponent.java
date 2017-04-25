package com.example.mrtan.app.view.userDetail;

import com.example.mrtan.app.internal.di.ScopeActivity;
import com.example.mrtan.app.internal.di.components.ApplicationComponent;
import dagger.Component;

/**
 * @author mrtan on 17-4-24.
 */
@ScopeActivity
@Component(dependencies = ApplicationComponent.class, modules = UserDetailModule.class)
public interface UserDetailComponent {
  void inject(UserDetailActivity activity);
}
