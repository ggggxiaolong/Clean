package com.example.mrtan.data.net;

import dagger.internal.Preconditions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author mrtan on 17-3-17.
 */

public class MockInterceptor implements Interceptor {
  final String mLocalJsonPath;

  public MockInterceptor() {
    String mLocalJsonPath1 = null;
    try {
      mLocalJsonPath1 = getClass().getResource("/json/").toURI().getPath();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    mLocalJsonPath = mLocalJsonPath1;
  }

  @Override public Response intercept(Chain chain) throws IOException {
    String body = createResponseBody(chain);
    if (body != null) {
      return new Response.Builder().code(200)
          .message("request ok")
          .request(chain.request())
          .protocol(Protocol.HTTP_1_1)
          .body(ResponseBody.create(MediaType.parse("application/json"), body.getBytes()))
          .addHeader("content-type", "application/json")
          .build();
    }
    return new Response.Builder().code(404)
        .message("Not Found")
        .request(chain.request())
        .protocol(Protocol.HTTP_1_1)
        .addHeader("content-type", "application/json")
        .body(ResponseBody.create(MediaType.parse("application/json"), "{}".getBytes()))
        .build();
  }

  String createResponseBody(Chain chain) {
    String requestPath = chain.request().url().url().getPath();
    if (requestPath.matches("/android10/Sample-Data/master/Android-CleanArchitecture/users.json")) {
      return getResponseJson("users.json");
    } else if (requestPath.matches("/android10/Sample-Data/master/Android-CleanArchitecture/user_1.json")) {
      return getResponseJson("user_1.json");
    }
    return null;
  }

  String getResponseJson(String fileName) {
    return readFromFile(mLocalJsonPath + fileName);
  }

  String readFromFile(String fileName){
    Preconditions.checkNotNull(fileName);
    StringBuilder builder = new StringBuilder();
    File file = new File(fileName);
    if (!file.exists()){
      return "";
    }
    try {
      String line;
      BufferedReader reader = new BufferedReader(new FileReader(file));
      while ((line = reader.readLine())!= null){
        builder.append(line);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return builder.toString();
  }
}
