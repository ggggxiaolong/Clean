package com.example.mrtan.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author mrtan 17-3-12
 */

public class UserTest {
  private static final int FAKE_USER_ID = 8;
  private User mUser;

  @Before
  public void setUser(){
    mUser = ImmutableUser.builder().userId(FAKE_USER_ID).fullName("test").followers(123).build();
    //mUser = new ImmutableU
  }

  @Test
  public void testUser(){
    int userId = mUser.userId();
    assertThat(userId).isEqualTo(FAKE_USER_ID);
  }
}