package com.example.mrtan.app.view.userDetail;

import android.content.Context;
import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.app.util.Utils;
import com.example.mrtan.domain.ImmutableUser;
import com.example.mrtan.domain.User;
import com.example.mrtan.domain.interactor.GetUserDetails;
import io.reactivex.observers.DisposableObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author mrtan on 17-4-25.
 */

@RunWith(MockitoJUnitRunner.class) public class UserDetailPresenterTest {
  public static final int USER_ID = 1;

  @Mock GetUserDetails mGetUserDetails;
  @Mock UserDetailView mUserDetailView;
  @Mock Context mContext;
  UserDetailPresenter mPresenter;

  @Before public void setup() {
    Utils.init(mContext);
    mPresenter = new UserDetailPresenter(mGetUserDetails, USER_ID, mUserDetailView);
  }

  @Test public void testLoad() {
    mPresenter.load();

    verify(mUserDetailView).hideRetry();
    verify(mUserDetailView).showLoading();
    verify(mGetUserDetails).execute(any(DisposableObserver.class),
        any(GetUserDetails.Params.class));
  }

  @Test public void testSuccess(){
    mPresenter.mUserObserver.onComplete();
    Utils.init(mContext);
    verify(mUserDetailView).hideLoading();
  }

  @Test public void testNext(){
    mPresenter.mUserObserver.onNext(createUser());

    verify(mUserDetailView).hideLoading();
    verify(mUserDetailView).showUser(any(UserModel.class));
  }

  @Test public void testDetach() {
    mPresenter.onDetach();
    verify(mGetUserDetails).dispose();
  }

  User createUser() {
    return ImmutableUser.builder()
        .userId(111)
        .followers(456)
        .fullName("jim")
        .build();
  }
}
