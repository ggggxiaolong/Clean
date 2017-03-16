package com.example.mrtan.data.entity.mapper;

import com.example.mrtan.data.entity.UserEntity;
import com.google.gson.JsonSyntaxException;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author mrtan on 17-3-16.
 */

@RunWith(MockitoJUnitRunner.class) public class UserEntityJsonMapperTest {
  public static final String USER_LIST_JSON = "[\n"
      + "    {\n"
      + "        \"id\": 1,\n"
      + "        \"full_name\": \"Simon Hill\",\n"
      + "        \"followers\": 7484\n"
      + "    },\n"
      + "    {\n"
      + "        \"id\": 2,\n"
      + "        \"full_name\": \"Peter Graham\",\n"
      + "        \"followers\": 7019\n"
      + "    },\n"
      + "    {\n"
      + "        \"id\": 3,\n"
      + "        \"full_name\": \"Angelina Johnston\",\n"
      + "        \"followers\": 2700\n"
      + "    }\n"
      + "]";
  public static final String USER_SINGLE_JSON = "{\n"
      + "    \"id\": 1,\n"
      + "    \"cover_url\": \"https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/cover_1.jpg\",\n"
      + "    \"full_name\": \"Simon Hill\",\n"
      + "    \"description\": \"Curabitur gravida nisi at nibh.\",\n"
      + "    \"followers\": 7484,\n"
      + "    \"email\": \"jcooper@babbleset.edu\"\n"
      + "}";
  private UserEntityJsonMapper mUserEntityJsonMapper;
  @Rule public ExpectedException mException = ExpectedException.none();

  @Before public void setUp() {
    mUserEntityJsonMapper = new UserEntityJsonMapper();
  }

  @Test public void testMapperSingle() {
    UserEntity userEntity = mUserEntityJsonMapper.transformUserEntity(USER_SINGLE_JSON);
    assertThat(userEntity.userId(), is(1));
    assertThat(userEntity.coverUrl(),
        is("https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/cover_1.jpg"));
    assertThat(userEntity.fullName(), is("Simon Hill"));
    assertThat(userEntity.description(), is("Curabitur gravida nisi at nibh."));
    assertThat(userEntity.followers(), is(7484));
    assertThat(userEntity.email(), is("jcooper@babbleset.edu"));
  }

  @Test public void testMapperList() {
    List<UserEntity> userEntities =
        mUserEntityJsonMapper.transformUserEntityCollection(USER_LIST_JSON);
    assertThat(userEntities.size(), is(3));
    assertThat(userEntities.get(0).userId(), is(1));
    assertThat(userEntities.get(1).userId(), is(2));
    assertThat(userEntities.get(2).userId(), is(3));
  }

  @Test public void testExceptionSingle(){
    mException.expect(JsonSyntaxException.class);
    mUserEntityJsonMapper.transformUserEntity("a");
  }

  @Test public void testList(){
    mException.expect(JsonSyntaxException.class);
    mUserEntityJsonMapper.transformUserEntityCollection("b");
  }
}
