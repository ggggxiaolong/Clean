package com.example.mrtan.app.model;

import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

/**
 * @author mrtan 17-3-18
 */
@Value.Immutable public abstract class UserModel {
  @Value.Parameter public abstract int userId();

  @Value.Parameter public abstract String fullName();

  @Value.Parameter public abstract int followers();

  @Nullable public abstract String coverUrl();

  @Nullable public abstract String email();

  @Nullable public abstract String description();
}
