package com.sananda.androidmvvmroomlivedatarecyclerview.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by sananda on 20/12/18.
 */

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void insertAll(List<User> users);

    @Insert(onConflict = REPLACE)
    void insert(User user);

    @Update(onConflict = REPLACE)
    void updateUsers(User languagesBean);

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT name FROM User")
    String[] getAllName();

    @Query("SELECT * FROM user WHERE email LIKE :email")
    User findByEmail(String email);
}
