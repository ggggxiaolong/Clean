package com.example.mrtan.app.mapper;

import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.mrtan.domain.ImmutableUser;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author mrtan on 17-4-25.
 */

@RunWith(MockitoJUnitRunner.class) public class UserModelDataMapperTest {

  static final String FAKE_FULL_NAME = "Tony";
  static final int FAKE_USER_ID = 123;
  static final int FAKE_FOLLOWERS = 231;

  @Test public void testTransformUser(){
    User user = createUser();
    UserModel userModel = UserModelDataMapper.transform(user);

    assertThat(userModel, is(instanceOf(UserModel.class)));
    assertThat(userModel.userId(), is(FAKE_USER_ID));
    assertThat(userModel.followers(), is(FAKE_FOLLOWERS));
    assertThat(userModel.fullName(), is(FAKE_FULL_NAME));
  }

  @Test public void testCollection(){
    User mockUserOne = createUser();
    User mockUserTwo = createUser();

    ArrayList<User> users = new ArrayList<>(5);
    users.add(mockUserOne);
    users.add(mockUserTwo);

    List<UserModel> modelList = UserModelDataMapper.transform(users);
    assertThat(modelList.get(0), is(instanceOf(UserModel.class)));
    assertThat(modelList.get(1), is(instanceOf(UserModel.class)));
    assertThat(modelList.size(), is(2));
  }

  User createUser() {
    return ImmutableUser.builder()
        .userId(FAKE_USER_ID)
        .followers(FAKE_FOLLOWERS)
        .fullName(FAKE_FULL_NAME)
        .build();
  }
}
