package com.example.mrtan.data.exception;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * @author mrtan on 17-3-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class RepositoryExceptionTest {
  @Mock Exception mException;
  private RepositoryErrorBundle mRepositoryErrorBundle;

  @Before public void setUp(){
    mRepositoryErrorBundle = new RepositoryErrorBundle(mException);
  }

  @Test public void testGetMessage(){
    mRepositoryErrorBundle.errorMessage();
    verify(mException).getMessage();
  }
}
