package com.example.mrtan.app.view.userDetail;

import dagger.Module;
import dagger.Provides;

/**
 * @author mrtan on 17-4-24.
 */
@Module
public class UserDetailModule {
  final int mUserId;
  final UserDetailView mUserDetailView;

  public UserDetailModule(int userId, UserDetailView userDetailView) {
    mUserId = userId;
    mUserDetailView = userDetailView;
  }

  @Provides int provideUserId(){
    return mUserId;
  }

  @Provides UserDetailView provideUserDetailView(){
    return mUserDetailView;
  }
}
