package com.example.mrtan.data;

import android.content.Context;
import java.io.File;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * @author mrtan on 17-3-16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = ApplicationSub.class, sdk = 21)
public abstract class ApplicationTestCase {

  @Rule public TestRule injectMockRule = (base, description) -> {
    MockitoAnnotations.initMocks(ApplicationTestCase.this);
    return base;
  };

  public static Context context(){
    return RuntimeEnvironment.application;
  }

  public static File cacheDir(){
    return RuntimeEnvironment.application.getCacheDir();
  }
}
