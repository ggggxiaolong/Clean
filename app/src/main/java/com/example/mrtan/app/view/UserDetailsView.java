package com.example.mrtan.app.view;

import com.example.mrtan.app.model.UserModel;

/**
 * @author mrtan 17-3-25
 */

public interface UserDetailsView extends LoadDataView{
  void renderUser(UserModel user);
}
