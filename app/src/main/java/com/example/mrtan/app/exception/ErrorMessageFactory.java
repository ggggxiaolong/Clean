package com.example.mrtan.app.exception;

import android.content.Context;
import com.example.mrtan.app.R;
import com.example.mrtan.app.util.Utils;
import com.example.mrtan.data.exception.UserNotFoundException;
import com.example.mrtan.data.exception.NetworkConnectionException;

/**
 * @author mrtan 17-3-18
 */

public class ErrorMessageFactory {
  private ErrorMessageFactory() {
  }

  public static String create(Exception exception) {
    String message = Utils.getString(R.string.error_exception_default);
    if (exception instanceof NetworkConnectionException) {
      message = Utils.getString(R.string.error_exception_network);
    } else if (exception instanceof UserNotFoundException) {
      message = Utils.getString(R.string.error_exception_user_null);
    }
    return message;
  }
}
