package com.example.mrtan.app.view.userDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.mrtan.app.R;
import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.app.view.base.BaseFragment;

import static com.example.mrtan.app.util.ViewUtils.setText;

/**
 * @author mrtan on 17-4-24.
 */

public class UserDetailFragment extends BaseFragment implements UserDetailView {

  UserDetailPresenter mPresenter;
  ProgressBar mProgress;
  ImageView mAvatar;
  TextView mEmail;
  TextView mFullName;
  TextView mFollowers;
  TextView mDescription;
  View mStubRetry;

  public static UserDetailFragment newInstance() {
    return new UserDetailFragment();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_user_detail, container, false);
    mProgress = (ProgressBar) view.findViewById(R.id.progress);
    mAvatar = (ImageView) view.findViewById(R.id.avatar);
    mEmail = (TextView) view.findViewById(R.id.email);
    mFullName = (TextView) view.findViewById(R.id.fullName);
    mFollowers = (TextView) view.findViewById(R.id.followers);
    mDescription = (TextView) view.findViewById(R.id.description);
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    mPresenter.load();
  }

  @Override public void showLoading() {
    if (mProgress.getVisibility() != View.VISIBLE) mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    if (mProgress.getVisibility() != View.GONE) mProgress.setVisibility(View.GONE);
  }

  @Override public void showRetry() {
    if (mStubRetry == null) {
      ViewStub stub = (ViewStub) getView().findViewById(R.id.stub_retry);
      mStubRetry = stub.inflate();
      mStubRetry.findViewById(R.id.bt_retry).setOnClickListener(v -> mPresenter.load());
    }

    if (mStubRetry.getVisibility() != View.VISIBLE) mStubRetry.setVisibility(View.VISIBLE);
  }

  @Override public void hideRetry() {
    if (mStubRetry != null && mStubRetry.getVisibility() != View.GONE) {
      mStubRetry.setVisibility(View.GONE);
    }
  }

  @Override public void showError(String message) {
    showToastMessage(message);
  }

  @Override public void setPresenter(UserDetailPresenter userDetailPresenter) {
    mPresenter = userDetailPresenter;
  }

  @Override public void showUser(UserModel userModel) {
    setText(mFullName, userModel.fullName());
    setText(mEmail, userModel.email());
    setText(mFollowers, userModel.followers());
    setText(mDescription, userModel.description());
    Glide.with(this).load(userModel.coverUrl()).into(mAvatar);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    mPresenter.onDetach();
  }
}
