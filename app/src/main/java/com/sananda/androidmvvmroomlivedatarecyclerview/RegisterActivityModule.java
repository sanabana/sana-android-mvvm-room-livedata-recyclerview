package com.sananda.androidmvvmroomlivedatarecyclerview;

import android.arch.lifecycle.ViewModelProvider;

import com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels.RegistrationViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sananda on 19/12/18.
 */

@Module
public class RegisterActivityModule {

    @Provides
    ViewModelProvider.Factory registerViewModelProvider(RegistrationViewModel registrationViewModel) {
        return new ViewModelProviderFactory<>(registrationViewModel);
    }

    @Provides
    RegistrationViewModel provideMainViewModel() {
        return new RegistrationViewModel();
    }
}
