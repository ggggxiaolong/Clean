package com.example.mrtan.app.view.userlist;

import com.example.mrtan.domain.interactor.GetUserList;
import io.reactivex.observers.DisposableObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author mrtan on 17-4-25.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserListPresenterTest {

  @Mock GetUserList mGetUserList;
  @Mock UserListView mUserListView;
  UserListPresenter mPresenter;

  @Before public void setup(){
    mPresenter = new UserListPresenter(mGetUserList);
    mPresenter.onAttach(mUserListView);
  }

  @Test public void testLoad(){
    mPresenter.load();

    verify(mUserListView).hideRetry();
    verify(mUserListView).showLoading();
    verify(mGetUserList).execute(any(DisposableObserver.class), any());
  }
}
