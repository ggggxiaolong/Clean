package com.example.mrtan.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * @author mrtan 17-3-12
 */

public class DefaultObserver<T> extends DisposableObserver<T> {
  @Override public void onNext(T t) {

  }

  @Override public void onError(Throwable e) {

  }

  @Override public void onComplete() {

  }
}
