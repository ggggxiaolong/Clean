package com.example.mrtan.app;

import android.content.Context;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * @author mrtan on 17-4-25.
 */
@RunWith(CustomRobolectricTestRunner.class)
@Config(constants = CustomBuildConfig.class, application = ApplicationSub.class, sdk = 23)
public abstract class ApplicationTestCase {

  public static Context context(){
    return RuntimeEnvironment.application;
  }
}
