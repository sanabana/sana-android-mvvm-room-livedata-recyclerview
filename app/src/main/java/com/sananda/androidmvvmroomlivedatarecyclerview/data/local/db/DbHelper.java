package com.sananda.androidmvvmroomlivedatarecyclerview.data.local.db;

import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by sananda on 20/12/18.
 */

public interface DbHelper {

    Observable<List<User>> getAllUsers();

    Observable<Boolean> insertUser(final User user);

}
