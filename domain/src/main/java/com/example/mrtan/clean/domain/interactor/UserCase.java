package com.example.mrtan.clean.domain.interactor;

import com.example.mrtan.clean.domain.executor.PostExecutionThread;
import com.example.mrtan.clean.domain.executor.ThreadExecutor;
import com.fernandocejas.arrow.checks.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tanxiaolong on 17/3/6.
 */

public abstract class UserCase<T, Params> {
    private final ThreadExecutor mThreadExecutor;

    private final PostExecutionThread mPostExecutionThread;

    private final CompositeDisposable mDisposable;

    UserCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, CompositeDisposable disposable) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
        mDisposable = disposable;
    }

    abstract Observable<T> buildUserCaseObservable(Params params);

    public void execute(DisposableObserver<T> observer, Params params){
        Preconditions.checkNotNull(observer);
        Observable<T> observable = buildUserCaseObservable(params)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.scheduler());

        addDisposable(observer);
    }

    public void dispose() {
        if (!mDisposable.isDisposed())
            mDisposable.dispose();
    }

    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(mDisposable);
        mDisposable.add(disposable);
    }
}
