package com.example.mrtan.clean.domain.interactor;

import com.example.mrtan.clean.domain.User;
import com.example.mrtan.clean.domain.executor.PostExecutionThread;
import com.example.mrtan.clean.domain.executor.ThreadExecutor;
import com.example.mrtan.clean.domain.repository.UserRepository;
import com.fernandocejas.arrow.checks.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by tanxiaolong on 17/3/6.
 */

public class GetUerDetails extends UserCase<User, GetUerDetails.Params> {

    private final UserRepository mUserRepository;

    GetUerDetails(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, CompositeDisposable disposable) {
        super(threadExecutor, postExecutionThread, disposable);
        mUserRepository = userRepository;
    }

    @Override
    public Observable<User> buildUserCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return mUserRepository.user(params.mUserId);
    }

    public static final class Params {
        final int mUserId;

        private Params(int userId){
            mUserId = userId;
        }

        public static Params forUser(int userId) {
            return new Params(userId);
        }
    }
}
