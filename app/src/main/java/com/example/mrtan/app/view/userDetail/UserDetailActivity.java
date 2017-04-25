package com.example.mrtan.app.view.userDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.mrtan.app.R;
import com.example.mrtan.app.view.base.BaseActivity;
import com.example.mrtan.domain.User;
import javax.inject.Inject;

/**
 * @author mrtan 17-4-13
 */

public class UserDetailActivity extends BaseActivity {
  public static final String USER_ID = "UserDetailActivity.userId";

  int mUserId;
  @Inject UserDetailPresenter mPresenter;

  public static void start(Context context, int userId) {
    Intent starter = new Intent(context, UserDetailActivity.class);
    starter.putExtra(USER_ID, userId);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_common);
    mUserId = getIntent().getIntExtra(USER_ID, -1);
    UserDetailFragment fragment =
        (UserDetailFragment) getFragmentManager().findFragmentById(R.id.container);
    if (fragment == null) {
      fragment = UserDetailFragment.newInstance();
      addFragment(R.id.container, fragment);
    }
    DaggerUserDetailComponent.builder()
        .applicationComponent(getApplicationComponent())
        .userDetailModule(new UserDetailModule(mUserId, fragment))
        .build()
        .inject(this);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    if (outState != null) outState.putInt(USER_ID, mUserId);
    super.onSaveInstanceState(outState);
  }
}
