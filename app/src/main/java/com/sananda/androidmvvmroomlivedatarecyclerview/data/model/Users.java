package com.sananda.androidmvvmroomlivedatarecyclerview.data.model;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;

import com.sananda.androidmvvmroomlivedatarecyclerview.SanaApp;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.local.db.AppDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sananda on 20/12/18.
 */

public class Users extends BaseObservable {
    private String status;
    private List<User> usersList = new ArrayList<>();
    private MutableLiveData<List<User>> users = new MutableLiveData<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addUser(User bd) {
        usersList.add(bd);
    }

    public MutableLiveData<List<User>> getUsers() {
        return users;
    }

    public void fetchList() {
                users.setValue(AppDatabase.getInMemoryDatabase(SanaApp.getAppContext()).userDao().getAll());
    }
}