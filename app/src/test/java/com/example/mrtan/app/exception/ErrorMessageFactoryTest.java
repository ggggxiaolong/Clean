package com.example.mrtan.app.exception;

import com.example.mrtan.app.ApplicationTestCase;
import com.example.mrtan.app.R;
import com.example.mrtan.app.util.Utils;
import com.example.mrtan.data.exception.NetworkConnectionException;
import com.example.mrtan.data.exception.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author mrtan 17-3-18
 */

public class ErrorMessageFactoryTest extends ApplicationTestCase{

  @Before public void setup() {
    Utils.init(context());
  }

  @Test public void testNetworkError() {
    String except = Utils.getString(R.string.error_exception_network);
    String result = ErrorMessageFactory.create(new NetworkConnectionException());

    assertThat(result, is(equalTo(except)));
  }

  @Test public void testUserError(){
    String except = Utils.getString(R.string.error_exception_user_null);
    String actual = ErrorMessageFactory.create(new UserNotFoundException());

    assertThat(actual, is(equalTo(except)));
  }
}