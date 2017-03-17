package com.example.mrtan.domain.exception;

/**
 * @author mrtan 17-3-12
 */

public class DefaultErrorBundle implements ErrorBundle {
  final Exception mException;
  public static final String DEFAULT_ERROR_MSG = "Unknown error";

  public DefaultErrorBundle(Exception exception) {
    mException = exception;
  }

  @Override public Exception exception() {
    return mException;
  }

  @Override public String errorMessage() {
    return (mException != null) ? mException.getMessage() : DEFAULT_ERROR_MSG;
  }
}
