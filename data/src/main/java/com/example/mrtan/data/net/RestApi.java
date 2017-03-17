package com.example.mrtan.data.net;

import com.example.mrtan.data.entity.UserEntity;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author mrtan 17-3-16
 */

public interface RestApi {
  String API_BASE_URL =
      "https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/";

  @GET("users.json") Observable<List<UserEntity>> users();

  @GET("user_{userId}.json") Observable<UserEntity> user(@Path("userId") int userId);
}
