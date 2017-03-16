package com.example.mrtan.data.exception;

import com.example.mrtan.domain.exception.ErrorBundle;

/**
 * @author mrtan on 17-3-16.
 */

public class RepositoryErrorBundle implements ErrorBundle {
  final Exception mException;

  public RepositoryErrorBundle(Exception exception) {
    mException = exception;
  }

  @Override public Exception exception() {
    return mException;
  }

  @Override public String errorMessage() {
    return mException != null ? mException.getMessage() : "";
  }
}
