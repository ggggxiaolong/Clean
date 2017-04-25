package com.example.mrtan.app.util;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * @author mrtan on 17-4-24.
 */

public class Utils {
  private Utils(){}
  static Context mContext;

  public static void init(Context context){
    mContext = context.getApplicationContext();
  }

  public static String getString(@StringRes int res){
    return mContext.getString(res);
  }
}
