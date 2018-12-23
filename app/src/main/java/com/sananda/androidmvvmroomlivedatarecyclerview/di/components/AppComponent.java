package com.sananda.androidmvvmroomlivedatarecyclerview.di.components;

import android.app.Application;

import com.sananda.androidmvvmroomlivedatarecyclerview.AppModule;
import com.sananda.androidmvvmroomlivedatarecyclerview.SanaApp;
import com.sananda.androidmvvmroomlivedatarecyclerview.di.builder.ActivityBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by sananda on 19/12/18.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(SanaApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
