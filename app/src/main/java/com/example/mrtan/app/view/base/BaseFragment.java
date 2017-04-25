package com.example.mrtan.app.view.base;

import android.app.Fragment;
import android.widget.Toast;
import com.example.mrtan.app.internal.di.HasComponent;

/**
 * @author mrtan on 17-4-21.
 */

public abstract class BaseFragment extends Fragment {

  protected void showToastMessage(String message){
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  @SuppressWarnings("unchecked")
  protected <C> C getComponent(Class<C> clazz){
    return clazz.cast(((HasComponent<C>)(getActivity())).getComponent());
  }
}
