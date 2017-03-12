package com.example.mrtan.clean.domain.interactor;

import com.example.mrtan.clean.domain.User;
import com.example.mrtan.clean.domain.executor.PostExecutionThread;
import com.example.mrtan.clean.domain.executor.ThreadExecutor;
import com.example.mrtan.clean.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by tanxiaolong on 17/3/6.
 */

public class GetUserList extends UserCase<List<User>, Void>{
    final UserRepository mUserRepository;

    GetUserList(UserRepository userRepository,ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, CompositeDisposable disposable) {
        super(threadExecutor, postExecutionThread, disposable);
        mUserRepository = userRepository;
    }


    @Override
    Observable<List<User>> buildUserCaseObservable(Void unuse) {
        return mUserRepository.users();
    }
}
