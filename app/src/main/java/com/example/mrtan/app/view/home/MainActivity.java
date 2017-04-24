package com.example.mrtan.app.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.mrtan.app.R;
import com.example.mrtan.app.navigation.Navigator;
import com.example.mrtan.app.view.base.BaseActivity;

/**
 * @author mrtan 17-4-13
 */

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void loadData(View view){
    Navigator.navigate2UserList(this);
  }
}
