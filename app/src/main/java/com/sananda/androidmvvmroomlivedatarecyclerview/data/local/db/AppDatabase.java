package com.sananda.androidmvvmroomlivedatarecyclerview.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.sananda.androidmvvmroomlivedatarecyclerview.data.local.db.dao.UserDao;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;

/**
 * Created by sananda on 20/12/18.
 */

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public abstract UserDao userDao();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "mvvm_room_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }
}
