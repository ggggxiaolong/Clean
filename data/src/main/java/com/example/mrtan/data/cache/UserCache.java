package com.example.mrtan.data.cache;

import com.example.mrtan.data.entity.UserEntity;
import io.reactivex.Observable;

/**
 * @author mrtan on 17-3-16.
 */

public interface UserCache {
  Observable<UserEntity> get(final int userId);

  void put(UserEntity userEntity);

  boolean isCached(final int userId);

  boolean isExpired();

  void evictAll();
}
