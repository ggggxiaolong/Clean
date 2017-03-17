package com.example.mrtan.data.cache;

import android.content.Context;
import com.example.mrtan.data.cache.serializer.Serializer;
import com.example.mrtan.data.entity.UserEntity;
import com.example.mrtan.data.exception.UserNotFoundException;
import io.reactivex.Observable;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author mrtan on 17-3-16.
 */
@Singleton
public class UserCacheImpl implements UserCache {
  static final String SETTING_FILE_NAME = "com.example.mrtan.settings";
  static final String SETTING_KEY_CACHE_UPDATE = "last_cache_update";
  static final String DEFAULT_FILE_NAME = "user_";
  static final long EXPIRATION_TIME = 60 * 10 * 1000;

  final Context mContext;
  final File mCacheDir;
  final Serializer mSerializer;

  @Inject
  public UserCacheImpl(Context context, Serializer serializer) {
    if (context == null) {
      throw new IllegalArgumentException("params can't be null");
    }
    mContext = context;
    mCacheDir = context.getCacheDir();
    mSerializer = serializer;
  }

  @Override public Observable<UserEntity> get(int userId) {
    return Observable.create(emitter -> {
      String userContent = FileManager.readFromFile(buildFile(userId));
      UserEntity userEntity = mSerializer.deserialize(userContent, UserEntity.class);
      if (userEntity != null){
        emitter.onNext(userEntity);
        emitter.onComplete();
      } else {
        emitter.onError(UserNotFoundException.DEFAULT);
      }
    });
  }

  @Override public void put(UserEntity userEntity) {
    if (userEntity != null){
      if (!isCached(userEntity.userId())){
        File file = buildFile(userEntity.userId());
        FileManager.writeToFile(file, mSerializer.serialize(userEntity));
      }
      setLastCacheUpdateTimeMillis();
    }
  }

  @Override public boolean isCached(int userId) {
    return buildFile(userId).exists();
  }

  @Override public boolean isExpired() {
    long timeMillis = getLastCacheUpdateTimeMillis();
    boolean expired = (System.currentTimeMillis() - timeMillis) > EXPIRATION_TIME;
    if (expired){
      evictAll();
    }
    return expired;
  }

  @Override public void evictAll() {
    FileManager.clearDirectory(mCacheDir);
  }

  File buildFile(int userId) {
    String fileName = mCacheDir.getPath() + File.separator + DEFAULT_FILE_NAME + userId;
    return new File(fileName);
  }

  void setLastCacheUpdateTimeMillis() {
    long millis = System.currentTimeMillis();
    FileManager.write2Preferences(mContext, SETTING_FILE_NAME, SETTING_KEY_CACHE_UPDATE, millis);
  }

  long getLastCacheUpdateTimeMillis() {
    return FileManager.getFromPreferences(mContext, SETTING_FILE_NAME, SETTING_KEY_CACHE_UPDATE);
  }
}
