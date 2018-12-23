package com.sananda.androidmvvmroomlivedatarecyclerview.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.sananda.androidmvvmroomlivedatarecyclerview.R;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.local.db.AppDatabase;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;
import com.sananda.androidmvvmroomlivedatarecyclerview.databinding.ActivityMainBinding;
import com.sananda.androidmvvmroomlivedatarecyclerview.navigators.MainNavigator;
import com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels.MainViewModel;

import javax.inject.Inject;

/**
 * Created by sananda on 19/12/18.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    @Inject
    MainViewModel mMainViewModel;
    private ActivityMainBinding mActivityMainBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);
    }

    @Override
    public void login() {
        String email = mActivityMainBinding.etEmail.getText().toString().trim();
        String password = mActivityMainBinding.etPassword.getText().toString().trim();
        if (email.isEmpty()) {
            Toast.makeText(this,  getString(R.string.rqrd_email), Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(this,  getString(R.string.rqrd_pass), Toast.LENGTH_SHORT).show();
        } else if (email != null && !email.isEmpty()) {
            AppDatabase appDatabase = AppDatabase.getInMemoryDatabase(this);
            User user = appDatabase.userDao().findByEmail(email);
            if (user != null) {
                if (email.equalsIgnoreCase(user.getEmail()) && password.equalsIgnoreCase(user.getPassword())) {
                    Toast.makeText(this,  getString(R.string.msg_success_login), Toast.LENGTH_SHORT).show();
                    Intent intent = DashboardActivity.newIntent(this);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this,  getString(R.string.msg_emial_pass_mismatch), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, getString(R.string.msg_login_failure), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void register() {
        Intent intent = RegisterActivity.newIntent(MainActivity.this);
        startActivity(intent);
        finish();
    }
}
