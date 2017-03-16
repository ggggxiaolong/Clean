package com.example.mrtan.domain.interactor;

import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import com.example.mrtan.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author mrtan on 17-3-16.
 */
@RunWith(MockitoJUnitRunner.class) public class GetUserListTest {

  @Mock private UserRepository mUserRepository;
  @Mock private ThreadExecutor mThreadExecutor;
  @Mock private PostExecutorThread mPostExecutorThread;
  private GetUserList mGetUserList;

  @Before public void setUp(){
    mGetUserList = new GetUserList(mThreadExecutor, mPostExecutorThread, mUserRepository);
  }

  @Test public void testGetUserList(){
    mGetUserList.buildUserCaseObservable(null);
    verify(mUserRepository).users();
    verifyNoMoreInteractions(mUserRepository);
  }
}
