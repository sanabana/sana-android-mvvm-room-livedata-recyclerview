package com.sananda.androidmvvmroomlivedatarecyclerview.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.arch.lifecycle.Observer;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.sananda.androidmvvmroomlivedatarecyclerview.R;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;
import com.sananda.androidmvvmroomlivedatarecyclerview.databinding.ActivityDashboardBinding;
import com.sananda.androidmvvmroomlivedatarecyclerview.navigators.DashboardNavigator;
import com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels.DashboardViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sananda on 19/12/18.
 */

public class DashboardActivity extends BaseActivity<ActivityDashboardBinding, DashboardViewModel> implements DashboardNavigator {
    @Inject
    DashboardViewModel mDashboardViewModel;
    private ActivityDashboardBinding mActivityDashboardBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, DashboardActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override
    public DashboardViewModel getViewModel() {
        return mDashboardViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityDashboardBinding = getViewDataBinding();
        mDashboardViewModel.setNavigator(this);
        setupListUpdate();
    }

    private void setupListUpdate() {
        mDashboardViewModel.fetchList();
        mDashboardViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (users.size() == 0) {
                    Toast.makeText(DashboardActivity.this, getString(R.string.no_data), Toast.LENGTH_SHORT).show();
                } else {
                    mDashboardViewModel.setUsersInAdapter(users);
                }
            }
        });
    }
}
