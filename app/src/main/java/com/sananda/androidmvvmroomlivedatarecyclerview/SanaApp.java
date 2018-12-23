package com.sananda.androidmvvmroomlivedatarecyclerview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.sananda.androidmvvmroomlivedatarecyclerview.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by sananda on 19/12/18.
 */

public class SanaApp extends Application implements HasActivityInjector {

    private static SanaApp instance;

    static {
        instance = null;
    }
    public SanaApp() {
        instance = this;
    }

    public static final Context getAppContext() {
        return instance.getApplicationContext();
    }

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
