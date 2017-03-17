package com.example.mrtan.data.entity.mapper;

import com.example.mrtan.data.entity.UserEntity;
import com.example.mrtan.domain.ImmutableUser;
import com.example.mrtan.domain.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author mrtan on 17-3-16.
 */
public class UserEntityDataMapper {

  public static User transform(UserEntity userEntity) {
    User user = null;
    if (userEntity != null) {
      user = ImmutableUser.builder()
          .userId(userEntity.userId())
          .fullName(userEntity.fullName())
          .coverUrl(userEntity.coverUrl())
          .description(userEntity.description())
          .email(userEntity.email())
          .followers(userEntity.followers())
          .build();
    }
    return user;
  }

  public static List<User> transform(Collection<UserEntity> userEntities) {
    ArrayList<User> users = new ArrayList<>(userEntities.size());
    for (UserEntity entity : userEntities) {
      User user = transform(entity);
      if (user != null) {
        users.add(user);
      }
    }
    return users;
  }
}
