package com.example.mrtan.domain.exception;

/**
 * @author mrtan 17-3-12
 */

public class DefaultError implements ErrorBundle {
  final Exception mException;
  public static final String DEFAULT_ERROR_MSG = "Unknown error";

  public DefaultError(Exception exception) {
    mException = exception;
  }

  @Override public Exception exception() {
    return mException;
  }

  @Override public String errorMessage() {
    return DEFAULT_ERROR_MSG;
  }
}
