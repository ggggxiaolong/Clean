package com.example.mrtan.app.view.userDetail;

import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.app.view.base.BaseView;
import com.example.mrtan.app.view.base.LoadDataView;

/**
 * @author mrtan on 17-4-24.
 */

public interface UserDetailView extends BaseView, LoadDataView {
  void setPresenter(UserDetailPresenter userDetailPresenter);

  void showUser(UserModel userModel);
}
