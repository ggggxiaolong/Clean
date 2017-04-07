package com.example.mrtan.app.view;

import com.example.mrtan.app.model.UserModel;
import java.util.Collection;

/**
 * @author mrtan 17-3-25
 */

public interface UserListView extends LoadDataView{
  void renderUserList(Collection<UserModel> userModelCollection);

  void viewUser(UserModel userModel);
}
