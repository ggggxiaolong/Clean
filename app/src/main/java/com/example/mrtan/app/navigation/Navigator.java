package com.example.mrtan.app.navigation;

import android.content.Context;
import com.example.mrtan.app.view.userDetail.UserDetailActivity;
import com.example.mrtan.app.view.userlist.UserListActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

import static com.fernandocejas.arrow.checks.Preconditions.checkNotNull;

/**
 * @author mrtan 17-3-25
 */
public class Navigator {

  private Navigator() {
  }

  public static void navigate2UserList(Context context){
    checkNotNull(context);
    UserListActivity.start(context);
  }

  public static void navigate2UserDetails(Context context, int userId){
    checkNotNull(context);
    UserDetailActivity.start(context, userId);
  }
}
