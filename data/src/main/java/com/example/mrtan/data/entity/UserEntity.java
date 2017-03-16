package com.example.mrtan.data.entity;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * @author mrtan on 17-3-16.
 */
@Gson.TypeAdapters @Value.Immutable public abstract class UserEntity {
  @SerializedName("id") @Value.Parameter public abstract int userId();

  @SerializedName("full_name") @Value.Parameter public abstract String fullName();

  @SerializedName("followers") @Value.Parameter public abstract int followers();

  @SerializedName("cover_url") @Nullable public abstract String coverUrl();

  @SerializedName("description") @Nullable public abstract String description();

  @SerializedName("email") @Nullable public abstract String email();
}
