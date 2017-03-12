package com.example.mrtan.domain.repository;

import com.example.mrtan.domain.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author mrtan 17-3-1
 * Interface that represents a Repository for getting {@link User} related data.
 */

public interface UserRepository {
    /**
     * Get an {@link Observable} witch will emit a list of {@link User}
     */
    Observable <List<User>> users();

    /**
     * Get an {@link Observable} which will emit a {@link User}
     * @param userId the user id used to retrieve user data.
     */

    Observable<User> user(final int userId);
}
