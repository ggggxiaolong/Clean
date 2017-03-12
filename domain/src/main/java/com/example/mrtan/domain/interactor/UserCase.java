package com.example.mrtan.domain.interactor;

import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import com.fernandocejas.arrow.checks.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author mrtan 17-3-12
 */

public abstract class UserCase<T, Params> {
  private final ThreadExecutor mThreadExecutor;
  private final PostExecutorThread mPostExecutorThread;
  private final CompositeDisposable mDisposable;

  public UserCase(ThreadExecutor threadExecutor, PostExecutorThread postExecutorThread) {
    mThreadExecutor = threadExecutor;
    mPostExecutorThread = postExecutorThread;
    mDisposable = new CompositeDisposable();
  }

  abstract Observable<T> buildUserCaseObservable(Params params);

  public void execute(DisposableObserver<T> observer, Params params){
    Preconditions.checkNotNull(observer);
    Observable<T> observable =
        buildUserCaseObservable(params).subscribeOn(Schedulers.from(mThreadExecutor))
            .observeOn(mPostExecutorThread.scheduler());
    addDisposable(observable.subscribeWith(observer));
  }

  public void dispose(){
    if (!mDisposable.isDisposed()){
      mDisposable.dispose();
    }
  }

  public void addDisposable(Disposable disposable){
    Preconditions.checkNotNull(mDisposable);
    Preconditions.checkNotNull(disposable);
    mDisposable.add(disposable);
  }
}
