package com.example.mrtan.domain.interactor;

import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import com.example.mrtan.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * @author mrtan 17-3-12
 */

@RunWith(MockitoJUnitRunner.class) public class GetUserDetailsTest {

  public static final int USER_ID = 123;
  private GetUserDetails mGetUserDetails;

  @Mock private UserRepository mockUserRepository;
  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutorThread mockPostExecutorThread;

  @Rule public ExpectedException mExpectedException = ExpectedException.none();

  @Before public void setUp() {
    mGetUserDetails =
        new GetUserDetails(mockThreadExecutor, mockPostExecutorThread, mockUserRepository);
  }

  @Test public void testGetUserDetailUseCaseObservable(){
    mGetUserDetails.buildUserCaseObservable(ImmutableParams.of(USER_ID));

    verify(mockUserRepository).user(USER_ID);
    verifyNoMoreInteractions(mockUserRepository);
    verifyZeroInteractions(mockPostExecutorThread);
    verifyZeroInteractions(mockThreadExecutor);
  }

  @Test public void testShouldFailWhenNoOrEmptyParameters(){
    mExpectedException.expect(NullPointerException.class);
    mGetUserDetails.buildUserCaseObservable(null);
  }
}
