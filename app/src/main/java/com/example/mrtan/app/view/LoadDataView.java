package com.example.mrtan.app.view;

import android.content.Context;

/**
 * @author mrtan 17-3-25
 */

public interface LoadDataView {

  void showLoading();

  void hideLoading();

  void showRetry();

  void hideRetry();

  void showError(String message);

  Context context();
}
