package com.example.mrtan.app.view.base;

/**
 * Created by mrtan on 17-4-21.
 */

public abstract class BasePresenter <V extends BaseView> {
  protected V mView;

  public void onAttach(V view){
    mView = view;
  }

  public abstract void onDetach();
}
