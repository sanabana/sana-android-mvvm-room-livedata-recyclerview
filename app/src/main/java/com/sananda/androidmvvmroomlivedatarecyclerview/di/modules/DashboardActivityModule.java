package com.sananda.androidmvvmroomlivedatarecyclerview.di.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.sananda.androidmvvmroomlivedatarecyclerview.ViewModelProviderFactory;
import com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels.DashboardViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sananda on 19/12/18.
 */

@Module
public class DashboardActivityModule {

    @Provides
    ViewModelProvider.Factory dashboardViewModelProvider(DashboardViewModel dashboardViewModel) {
        return new ViewModelProviderFactory<>(dashboardViewModel);
    }

    @Provides
    public DashboardViewModel provideDashboardViewModel() {
        return new DashboardViewModel();
    }
}
