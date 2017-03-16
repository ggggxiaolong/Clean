package com.example.mrtan.data.cache.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ServiceLoader;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author mrtan on 17-3-16.
 */
@Singleton public class Serializer {
  final Gson mGson;

  @Inject public Serializer() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    for (TypeAdapterFactory factory : ServiceLoader.load(TypeAdapterFactory.class)) {
      gsonBuilder.registerTypeAdapterFactory(factory);
    }
    mGson = gsonBuilder.create();
  }

  public String serialize(Object o) {
    return mGson.toJson(o);
  }

  public <T> T deserialize(String json, Class<T> clazz) {
    return mGson.fromJson(json, clazz);
  }
}
