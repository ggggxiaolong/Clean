package com.example.mrtan.domain.interactor;

import com.example.mrtan.domain.User;
import com.example.mrtan.domain.executor.PostExecutorThread;
import com.example.mrtan.domain.executor.ThreadExecutor;
import com.example.mrtan.domain.repository.UserRepository;
import com.fernandocejas.arrow.checks.Preconditions;
import io.reactivex.Observable;
import org.immutables.value.Value;
import javax.inject.Inject;

/**
 * @author mrtan 17-3-12
 */

public class GetUserDetails extends UserCase<User, GetUserDetails.Params> {

  final UserRepository mUserRepository;

  @Inject public GetUserDetails(ThreadExecutor threadExecutor, PostExecutorThread postExecutorThread,
      UserRepository userRepository) {
    super(threadExecutor, postExecutorThread);
    mUserRepository = userRepository;
  }

  @Override Observable<User> buildUserCaseObservable(Params params) {
    Preconditions.checkNotNull(params);
    return mUserRepository.user(params.userId());
  }

  public interface Params {
    int userId();
  }
}
