package com.sananda.androidmvvmroomlivedatarecyclerview.di.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.sananda.androidmvvmroomlivedatarecyclerview.ViewModelProviderFactory;
import com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sananda on 19/12/18.
 */

@Module
public class MainActivityModule {

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

    @Provides
    public MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }
}
