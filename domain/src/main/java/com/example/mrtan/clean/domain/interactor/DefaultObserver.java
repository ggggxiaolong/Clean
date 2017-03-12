package com.example.mrtan.clean.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by tanxiaolong on 17/3/6.
 */

public class DefaultObserver<T> extends DisposableObserver {
    @Override
    public void onNext(Object o) {
        //no-op default.
    }

    @Override
    public void onError(Throwable e) {
        //no-op default.
    }

    @Override
    public void onComplete() {
        //no-op default.
    }
}
