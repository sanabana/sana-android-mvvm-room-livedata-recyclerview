package com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels;

import android.arch.lifecycle.MutableLiveData;

import com.sananda.androidmvvmroomlivedatarecyclerview.R;
import com.sananda.androidmvvmroomlivedatarecyclerview.adapter.UsersAdapter;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.Users;
import com.sananda.androidmvvmroomlivedatarecyclerview.navigators.DashboardNavigator;

import java.util.List;

/**
 * Created by sananda on 19/12/18.
 */

public class DashboardViewModel extends BaseViewModel<DashboardNavigator> {

    private Users users;
    private UsersAdapter adapter;

    public void fetchList() {
        users = new Users();
        users.fetchList();
    }

    public MutableLiveData<List<User>> getUsers() {
        return users.getUsers();
    }

    public UsersAdapter getAdapter() {
        adapter = new UsersAdapter(R.layout.view_user, this);
        return adapter;
    }

    public void setUsersInAdapter(List<User> users) {
        this.adapter.setUsers(users);
        this.adapter.notifyDataSetChanged();
    }

    public User getUserAt(Integer index) {
        if (users.getUsers().getValue() != null &&
                index != null &&
                users.getUsers().getValue().size() > index) {
            return users.getUsers().getValue().get(index);
        }
        return null;
    }

    }

