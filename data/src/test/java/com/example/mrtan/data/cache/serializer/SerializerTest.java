package com.example.mrtan.data.cache.serializer;

import com.example.mrtan.data.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mrtan on 17-3-16.
 */

public class SerializerTest {

  public static final String USER_SINGLE_JSON = "{\n"
      + "    \"id\": 1,\n"
      + "    \"cover_url\": \"cover_1.jpg\",\n"
      + "    \"full_name\": \"Simon Hill\",\n"
      + "    \"description\": \"Curabitur gravida nisi at nibh.\",\n"
      + "    \"followers\": 7484,\n"
      + "    \"email\": \"jcooper@babbleset.edu\"\n"
      + "}";
  private Serializer mSerializer;

  @Before public void setUp(){
    mSerializer = new Serializer();
  }

  @Test public void testDeserializer(){
    UserEntity entity = mSerializer.deserialize(USER_SINGLE_JSON, UserEntity.class);
    assertThat(entity.userId(), is(1));
    assertThat(entity.email(), is("jcooper@babbleset.edu"));
    assertThat(entity.fullName(), is("Simon Hill"));
    assertThat(entity.followers(), is(7484));
    assertThat(entity.description(), is("Curabitur gravida nisi at nibh."));
    assertThat(entity.coverUrl(), is("cover_1.jpg"));
  }

  @Test public void testSerializer(){
    UserEntity user1 = mSerializer.deserialize(USER_SINGLE_JSON, UserEntity.class);
    String content = mSerializer.serialize(user1);
    UserEntity user2 = mSerializer.deserialize(content, UserEntity.class);
    assertThat(user1.userId(), is(user2.userId()));
    assertThat(user1.coverUrl(), is(user2.coverUrl()));
    assertThat(user1.fullName(), is(user2.fullName()));
    assertThat(user1.description(), is(user2.description()));
    assertThat(user1.followers(), is(user2.followers()));
    assertThat(user1.email(), is(user2.email()));
  }
}
