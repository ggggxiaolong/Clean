package com.example.mrtan.clean.domain;

import org.immutables.value.Value;

/**
 * Created by tanxiaolong on 17/3/6.
 */

@Value.Immutable
public abstract class User {
    public abstract int userId();

    public abstract String coverUrl();

    public abstract String fullName();

    public abstract String email();

    public abstract String description();

    public abstract int followers();
}
