package com.example.mrtan.data.repository;

import com.example.mrtan.data.cache.UserCache;
import com.example.mrtan.data.entity.ImmutableUserEntity;
import com.example.mrtan.data.entity.UserEntity;
import com.example.mrtan.data.net.RestApi;
import io.reactivex.Observable;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author mrtan on 17-3-17.
 */
@RunWith(MockitoJUnitRunner.class) public class UserDataRepositoryTest {
  static final int FACK_USER_ID = 9;

  @Mock UserCache mUserCache;
  @Mock RestApi mRestApi;
  private UserDataRepository mUserDataRepository;

  @Before public void setUp() {
    mUserDataRepository = new UserDataRepository(mRestApi, mUserCache);
  }

  @Test public void testUsers() {
    when(mRestApi.users()).thenReturn(Observable.create(e -> e.onNext(new ArrayList<>())));
    mUserDataRepository.users();
    verify(mRestApi).users();
  }

  @Test public void testCahe() {
    beforTestCache();
    mUserDataRepository.user(FACK_USER_ID);
    verify(mUserCache).isExpired();
    verify(mUserCache).isCached(FACK_USER_ID);
    verify(mUserCache).get(FACK_USER_ID);
  }

  @Test public void TestApiUser() {
    when(mUserCache.isExpired()).thenReturn(true);
    beforTestApi();
    mUserDataRepository.user(FACK_USER_ID);
    verify(mRestApi).user(FACK_USER_ID);
  }

  void beforTestApi() {
    when(mRestApi.user(FACK_USER_ID)).thenReturn(
        Observable.create(e -> e.onNext(createTestUserEntity())));
  }

  void beforTestCache() {
    when(mUserCache.isExpired()).thenReturn(false);
    when(mUserCache.isCached(FACK_USER_ID)).thenReturn(true);
    when(mUserCache.get(FACK_USER_ID)).thenReturn(
        Observable.create(e -> e.onNext(createTestUserEntity())));
  }

  UserEntity createTestUserEntity() {
    return ImmutableUserEntity.of(FACK_USER_ID, "mrtan", 1000);
  }
}
