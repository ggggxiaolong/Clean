package com.example.mrtan.data.entity.mapper;

import com.example.mrtan.data.entity.GsonAdaptersUserEntity;
import com.example.mrtan.data.entity.UserEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author mrtan on 17-3-16.
 */
@Singleton public class UserEntityJsonMapper {
  final Gson mGson;

  @Inject public UserEntityJsonMapper() {
    mGson = new GsonBuilder().registerTypeAdapterFactory(new GsonAdaptersUserEntity()).create();
  }

  public UserEntity transformUserEntity(String userJsonResponse) throws JsonSyntaxException {
    Type type = new TypeToken<UserEntity>() {
    }.getType();
    return mGson.fromJson(userJsonResponse, type);
  }

  public List<UserEntity> transformUserEntityCollection(String userListJsonResponse)
      throws JsonSyntaxException {
    Type type = new TypeToken<List<UserEntity>>() {
    }.getType();
    return mGson.fromJson(userListJsonResponse, type);
  }
}
