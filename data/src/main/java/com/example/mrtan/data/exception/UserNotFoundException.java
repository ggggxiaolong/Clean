package com.example.mrtan.data.exception;

/**
 * @author mrtan on 17-3-16.
 */

public class UserNotFoundException extends Exception {
  public static UserNotFoundException DEFAULT = new UserNotFoundException();
}
