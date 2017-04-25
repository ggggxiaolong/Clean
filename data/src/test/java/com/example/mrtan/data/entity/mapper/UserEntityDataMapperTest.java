package com.example.mrtan.data.entity.mapper;

import com.example.mrtan.data.entity.ImmutableUserEntity;
import com.example.mrtan.data.entity.UserEntity;
import com.example.mrtan.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;

/**
 * @author mrtan on 17-3-16.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserEntityDataMapperTest {
  static final int FAKE_USER_ID = 123;
  static final int FAKE_FOLLOWERS = 10;
  static final String FAKE_FULLNAME = "mrtan";

  @Before public void setUp(){
  }

  @Test public void testTransformEntity(){
    UserEntity userEntity = createUserEntity();
    User user = UserEntityDataMapper.transform(userEntity);

    assertThat(user, is(instanceOf(User.class)));
    assertThat(user.userId(), is(FAKE_USER_ID));
    assertThat(user.fullName(), is(FAKE_FULLNAME));
    assertThat(user.followers(), is(FAKE_FOLLOWERS));
  }

  @Test public void testTransformList(){
    UserEntity mock1 = createUserEntity();
    UserEntity mock2 = createUserEntity();
    ArrayList<UserEntity> origin = new ArrayList<>();
    origin.add(mock1);
    origin.add(mock2);
    List<User> users = UserEntityDataMapper.transform(origin);
    assertThat(users.size(), is(2));
    assertThat(users.get(0), is(instanceOf(User.class)));
    assertThat(users.get(1), is(instanceOf(User.class)));
  }

  UserEntity createUserEntity(){
    return ImmutableUserEntity.of(FAKE_USER_ID, FAKE_FULLNAME, FAKE_FOLLOWERS);
  }
}
