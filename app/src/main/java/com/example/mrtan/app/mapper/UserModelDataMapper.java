package com.example.mrtan.app.mapper;

import com.annimon.stream.Stream;
import com.example.mrtan.app.model.ImmutableUserModel;
import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.domain.User;
import com.fernandocejas.arrow.checks.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mrtan 17-3-18
 */
public class UserModelDataMapper {

  private UserModelDataMapper() {
  }

  public static UserModel transform(User user) {
    Preconditions.checkNotNull(user);
    return ImmutableUserModel.builder()
        .userId(user.userId())
        .coverUrl(user.coverUrl())
        .description(user.description())
        .email(user.email())
        .followers(user.followers())
        .fullName(user.fullName())
        .build();
  }

  public static List<UserModel> transform(List<User> users) {
    List<UserModel> userModels;
    if (users != null && !users.isEmpty()) {
      userModels = new ArrayList<>(users.size());
      Stream.of(users).forEach(user -> userModels.add(transform(user)));
    } else {
      userModels = Collections.EMPTY_LIST;
    }
    return userModels;
  }
}
