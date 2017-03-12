package com.example.mrtan.domain.interactor;

import com.example.mrtan.domain.User;
import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import com.example.mrtan.domain.repository.UserRepository;
import io.reactivex.Observable;
import java.util.List;

/**
 * @author mrtan 17-3-12
 */

public class GetUserList extends UserCase<List<User>, Void> {
  final UserRepository mUserRepository;

  public GetUserList(ThreadExecutor threadExecutor, PostExecutorThread postExecutorThread,
      UserRepository userRepository) {
    super(threadExecutor, postExecutorThread);
    mUserRepository = userRepository;
  }

  @Override Observable<List<User>> buildUserCaseObservable(Void aVoid) {
    return mUserRepository.users();
  }
}
