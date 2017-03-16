package com.example.mrtan.domain.interactor;

import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author mrtan on 17-3-16.
 */
@RunWith(MockitoJUnitRunner.class) public class UserCaseTest {

  @Mock private ThreadExecutor mThreadExecutor;
  @Mock private PostExecutorThread mPostExecutorThread;

  @Rule private ExpectedException mException = ExpectedException.none();

  private TestUserCase mTestUserCase;
  private TestDisposable mTestDisposable;

  @Before public void setUp() {
    mTestUserCase = new TestUserCase(mThreadExecutor, mPostExecutorThread);
    mTestDisposable = new TestDisposable();
    given(mPostExecutorThread.scheduler()).willReturn(new TestScheduler());
  }

  @Test public void testExecute() {
    mTestUserCase.execute(mTestDisposable, Params.EMPTY);
    assertThat(mTestDisposable.count).isZero();
  }

  @Test public void testDispose() {
    mTestUserCase.execute(mTestDisposable, Params.EMPTY);
    mTestUserCase.dispose();
    assertThat(mTestDisposable.isDisposed()).isTrue();
  }

  @Test public void testNullParams(){
    mException.expect(NullPointerException.class);
    mTestUserCase.execute(null, Params.EMPTY);
  }

  private static class TestUserCase extends UserCase<Object, Params> {
    public TestUserCase(ThreadExecutor threadExecutor, PostExecutorThread postExecutorThread) {
      super(threadExecutor, postExecutorThread);
    }

    @Override Observable<Object> buildUserCaseObservable(Params params) {
      return Observable.empty();
    }

    @Override public void execute(DisposableObserver<Object> observer, Params params) {
      super.execute(observer, params);
    }
  }

  private static class TestDisposable extends DisposableObserver {
    int count = 0;

    @Override public void onNext(Object o) {
      count++;
    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onComplete() {

    }
  }

  private static class Params {
    public static Params EMPTY = new Params();
  }
}
