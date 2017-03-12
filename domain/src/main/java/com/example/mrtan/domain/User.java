package com.example.mrtan.domain;

import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

/**
 * @author mrtan 17-3-1
 */

@Value.Immutable public abstract class User {
  public abstract int userId();

  public abstract String fullName();

  public abstract int followers();

  @Nullable public abstract String coverUrl();

  @Nullable public abstract String email();

  @Nullable public abstract String description();
}
