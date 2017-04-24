package com.example.mrtan.app.view.userlist;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mrtan.app.R;
import com.example.mrtan.app.model.UserModel;
import com.example.mrtan.app.navigation.Navigator;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * @author mrtan on 17-4-24.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

  final Activity mActivity;
  @Inject UsersAdapter(Activity activity){
    mActivity = activity;
  }

  final ArrayList<UserModel> mUserModels = new ArrayList<>();

  void setData(List<UserModel> userModels){
    mUserModels.clear();
    if (userModels == null) return;
    mUserModels.addAll(userModels);
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    return new ViewHolder(inflater.inflate(R.layout.item_user, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    final UserModel userModel = mUserModels.get(position);
    holder.title.setText(userModel.fullName());
    holder.itemView.setOnClickListener(v -> Navigator.navigate2UserDetails(mActivity, userModel.userId()));
  }

  @Override public int getItemCount() {
    return mUserModels.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    final TextView title;
    public ViewHolder(View itemView) {
      super(itemView);
      title = (TextView) itemView.findViewById(R.id.title);
    }
  }
}
