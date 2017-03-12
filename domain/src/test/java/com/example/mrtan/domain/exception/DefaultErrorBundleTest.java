package com.example.mrtan.domain.exception;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * @author mrtan 17-3-12
 */

@RunWith(MockitoJUnitRunner.class) public class DefaultErrorBundleTest {
  private DefaultErrorBundle mDefaultErrorBundle;

  @Mock private Exception mockException;

  @Before
  public void setUp(){
    mDefaultErrorBundle = new DefaultErrorBundle(mockException);
  }

  @Test
  public void testGetMessageInteraction(){
    mDefaultErrorBundle.errorMessage();
    verify(mockException).getMessage();
  }
}
