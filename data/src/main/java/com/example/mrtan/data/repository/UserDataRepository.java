package com.example.mrtan.data.repository;

import com.example.mrtan.data.cache.UserCache;
import com.example.mrtan.data.entity.mapper.UserEntityDataMapper;
import com.example.mrtan.data.net.RestApi;
import com.example.mrtan.domain.User;
import com.example.mrtan.domain.repository.UserRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author mrtan on 17-3-17.
 */
@Singleton public class UserDataRepository implements UserRepository {
  final RestApi mRestApi;
  final UserCache mUserCache;

  @Inject
  public UserDataRepository(RestApi restApi, UserCache userCache) {
    mRestApi = restApi;
    mUserCache = userCache;
  }

  @Override public Observable<List<User>> users() {
    return mRestApi.users().map(UserEntityDataMapper::transform);
  }

  @Override public Observable<User> user(int userId) {
    if (mUserCache.isExpired() || !mUserCache.isCached(userId)) {
      return mRestApi.user(userId).map(userEntity -> {
        mUserCache.put(userEntity);
        return UserEntityDataMapper.transform(userEntity);
      });
    }
    return mUserCache.get(userId).map(UserEntityDataMapper::transform);
  }
}
