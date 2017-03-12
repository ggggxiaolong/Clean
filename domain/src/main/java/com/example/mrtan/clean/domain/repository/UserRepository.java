package com.example.mrtan.clean.domain.repository;

import com.example.mrtan.clean.domain.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tanxiaolong on 17/3/6.
 */

public interface UserRepository {

    Observable<List<User>> users();

    Observable<User> user(final int userId);

}
