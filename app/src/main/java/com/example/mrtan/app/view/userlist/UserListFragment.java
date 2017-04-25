package com.example.mrtan.app.view.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.example.mrtan.app.R;
import com.example.mrtan.app.internal.di.components.UserComponent;
import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.app.view.base.BaseFragment;
import java.util.List;
import javax.inject.Inject;

/**
 * @author mrtan on 17-4-21.
 */

public class UserListFragment extends BaseFragment implements UserListView {

  RecyclerView mRecycler;
  View mProgress, mRetry;
  @Inject UsersAdapter mUsersAdapter;
  @Inject UserListPresenter mPresenter;

  public static UserListFragment newInstance() {
    return new UserListFragment();
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(UserComponent.class).inject(this);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_user_list, container, false);
    mRecycler = (RecyclerView) view.findViewById(R.id.rv_user);
    mProgress = view.findViewById(R.id.progress);
    mRecycler.setAdapter(mUsersAdapter);
    mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mPresenter.onAttach(this);
    if (savedInstanceState == null) {
      mPresenter.load();
    }
  }

  @Override public void showLoading() {
    if (mProgress.getVisibility() != View.VISIBLE) mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    if (mProgress.getVisibility() != View.GONE) mProgress.setVisibility(View.GONE);
  }

  @Override public void showRetry() {
    if (mRetry == null) {
      ViewStub viewStub = (ViewStub) getView().findViewById(R.id.stub_retry);
      mRetry = viewStub.inflate();
    }
    if (mRetry.getVisibility() != View.VISIBLE) mRetry.setVisibility(View.VISIBLE);
  }

  @Override public void hideRetry() {
    if (mRetry != null && mRetry.getVisibility() != View.GONE) mRetry.setVisibility(View.GONE);
  }

  @Override public void showError(String message) {
    showToastMessage(message);
  }

  @Override public void renderUserList(List<UserModel> userModelCollection) {
    mUsersAdapter.setData(userModelCollection);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    mPresenter.onDetach();
  }
}
