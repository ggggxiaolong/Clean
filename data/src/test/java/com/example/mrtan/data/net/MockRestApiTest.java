package com.example.mrtan.data.net;

import com.example.mrtan.data.BuildConfig;
import java.net.URISyntaxException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import retrofit2.HttpException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;

/**
 * @author mrtan on 17-3-17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MockRestApiTest {
  private RestApi mRestApi;

  @Rule public ExpectedException mException = ExpectedException.none();

  @Before public void setUp() throws URISyntaxException {
    ShadowLog.stream = System.out;
    mRestApi = DaggerNetComponent.builder()
        .netModule(new NetModule())
        .build()
        .getRestApi();
  }

  @Test public void testUsers(){
    mRestApi.users().subscribe(userEntities -> {
      assertThat(userEntities.size(), is(12));
      assertThat(userEntities.get(0).userId(), is(1));
    });
  }

  @Test public void testUser(){
    mRestApi.user(1).subscribe(userEntity -> {
      assertThat(userEntity.userId(), is(1));
      assertThat(userEntity.fullName(), is("Simon Hill"));
      assertThat(userEntity.followers(), is(7484));
    });
  }

  @Test public void testUserError(){
    mRestApi.user(2).subscribe(userEntity -> {}, throwable -> {
      assertThat(throwable, is(instanceOf(HttpException.class)));
      HttpException httpException = (HttpException) throwable;
      assertThat(httpException.code(), is(404));
    });
  }
}
