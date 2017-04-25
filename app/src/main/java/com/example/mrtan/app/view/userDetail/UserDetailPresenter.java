package com.example.mrtan.app.view.userDetail;

import com.example.mrtan.app.exception.ErrorMessageFactory;
import com.example.mrtan.app.mapper.UserModelDataMapper;
import com.example.mrtan.app.view.base.BasePresenter;
import com.example.mrtan.domain.User;
import com.example.mrtan.domain.interactor.GetUserDetails;
import io.reactivex.observers.DisposableObserver;
import javax.inject.Inject;

/**
 * @author mrtan on 17-4-24.
 */

public class UserDetailPresenter extends BasePresenter<UserDetailView> {
  final GetUserDetails mUserDetails;
  final int mUserId;

  @Inject UserDetailPresenter(GetUserDetails getUserDetails, int userId, UserDetailView userDetailView) {
    mUserDetails = getUserDetails;
    mUserId = userId;
    mView = userDetailView;
  }

  @Inject void init(){
    mView.setPresenter(this);
  }

  void load() {
    mView.hideRetry();
    mView.showLoading();
    mUserDetails.execute(mUserObserver, () -> mUserId);
  }

  final DisposableObserver<User> mUserObserver = new DisposableObserver<User>() {
    @Override public void onComplete() {
      mView.hideLoading();
    }

    @Override public void onNext(User user) {
      mView.hideLoading();
      mView.showUser(UserModelDataMapper.transform(user));
    }

    @Override public void onError(Throwable e) {
      mView.showError(ErrorMessageFactory.create((Exception) e));
      mView.hideLoading();
      mView.showRetry();
    }
  };

  @Override public void onDetach() {
    mUserDetails.dispose();
    mView = null;
  }
}
