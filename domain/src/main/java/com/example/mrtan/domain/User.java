package com.example.mrtan.domain;

import org.immutables.value.Value;

/**
 * @author mrtan 17-3-1
 */

@Value.Immutable
public abstract class User {
    public abstract String coverUrl();

    public abstract String fullName();

    public abstract String email();

    public abstract String description();

    public abstract int followers();
}
