package com.example.mrtan.app.view.userlist;

import com.example.mrtan.app.exception.ErrorMessageFactory;
import com.example.mrtan.app.mapper.UserModelDataMapper;
import com.example.mrtan.app.view.base.BasePresenter;
import com.example.mrtan.domain.User;
import com.example.mrtan.domain.interactor.GetUserList;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

/**
 * @author mrtan on 17-4-21.
 */

public class UserListPresenter extends BasePresenter<UserListView> {
  final GetUserList mGetUserList;

  @Inject public UserListPresenter(GetUserList getUserList) {
    mGetUserList = getUserList;
  }

  void load(){
    mView.hideRetry();
    mView.showLoading();
    DisposableObserver<List<User>> observer = new DisposableObserver<List<User>>() {
      @Override public void onNext(List<User> users) {
        mView.renderUserList(UserModelDataMapper.transform(users));
      }

      @Override public void onError(Throwable e) {
        mView.hideLoading();
        mView.showRetry();
        mView.showError(ErrorMessageFactory.create((Exception) e));
      }

      @Override public void onComplete() {
        mView.hideLoading();
      }
    };
    mGetUserList.execute(observer, null);
  }

  @Override public void onDetach() {
    mGetUserList.dispose();
    mView = null;
  }
}
