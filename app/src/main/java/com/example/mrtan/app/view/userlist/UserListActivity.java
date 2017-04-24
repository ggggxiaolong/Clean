package com.example.mrtan.app.view.userlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.mrtan.app.R;
import com.example.mrtan.app.internal.di.HasComponent;
import com.example.mrtan.app.internal.di.components.DaggerUserComponent;
import com.example.mrtan.app.internal.di.components.UserComponent;
import com.example.mrtan.app.internal.di.modules.ActivityModule;
import com.example.mrtan.app.internal.di.modules.UserModule;
import com.example.mrtan.app.view.base.BaseActivity;

/**
 * @author mrtan 17-4-13
 */

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent> {

  public static void start(Context context) {
    Intent starter = new Intent(context, UserListActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_common);
    if (savedInstanceState == null) {
      addFragment(R.id.container, UserListFragment.newInstance());
    }
  }

  @Override public UserComponent getComponent() {
    return DaggerUserComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(new ActivityModule(this))
        .userModule(new UserModule())
        .build();
  }
}
