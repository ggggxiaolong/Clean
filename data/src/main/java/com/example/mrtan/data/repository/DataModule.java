package com.example.mrtan.data.repository;

import com.example.mrtan.data.cache.UserCache;
import com.example.mrtan.data.cache.UserCacheImpl;
import com.example.mrtan.data.net.RestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import java.util.ServiceLoader;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author mrtan on 17-3-17.
 */
@Module public class DataModule {
  @Singleton @Provides Gson provideGson() {
    GsonBuilder builder = new GsonBuilder();
    for (TypeAdapterFactory factory : ServiceLoader.load(TypeAdapterFactory.class)) {
      builder.registerTypeAdapterFactory(factory);
    }
    return builder.create();
  }

  @Singleton @Provides OkHttpClient client() {
    return new OkHttpClient.Builder().build();
  }

  @Singleton @Provides RestApi provideApi(OkHttpClient client, Gson gson) {
    return new Retrofit.Builder().baseUrl(RestApi.API_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RestApi.class);
  }

  @Singleton @Provides UserCache provideUserCahe(UserCacheImpl userCache) {
    return userCache;
  }
}
