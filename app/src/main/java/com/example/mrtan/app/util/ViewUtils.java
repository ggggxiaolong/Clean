package com.example.mrtan.app.util;

import android.widget.TextView;

/**
 * @author mrtan on 17-4-24.
 */

public class ViewUtils {
  private ViewUtils(){}

  public static void setText(TextView text, String message){
    text.setText(message);
  }

  public static void setText(TextView text, int message){
    text.setText(String.valueOf(message));
  }
}
