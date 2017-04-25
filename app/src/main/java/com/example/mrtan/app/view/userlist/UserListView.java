package com.example.mrtan.app.view.userlist;

import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.app.view.base.BaseView;
import com.example.mrtan.app.view.base.LoadDataView;
import java.util.Collection;
import java.util.List;

/**
 * @author mrtan 17-3-25
 */

public interface UserListView extends LoadDataView, BaseView {
  void renderUserList(List<UserModel> userModelCollection);
}
