package com.sananda.androidmvvmroomlivedatarecyclerview.di.builder;

import com.sananda.androidmvvmroomlivedatarecyclerview.di.modules.DashboardActivityModule;
import com.sananda.androidmvvmroomlivedatarecyclerview.di.modules.MainActivityModule;
import com.sananda.androidmvvmroomlivedatarecyclerview.RegisterActivityModule;
import com.sananda.androidmvvmroomlivedatarecyclerview.views.DashboardActivity;
import com.sananda.androidmvvmroomlivedatarecyclerview.views.MainActivity;
import com.sananda.androidmvvmroomlivedatarecyclerview.views.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by sananda on 19/12/18.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            RegisterActivityModule.class})
    abstract RegisterActivity bindRegisterActivity();

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {
            DashboardActivityModule.class})
    abstract DashboardActivity bindDashboardActivity();

}
