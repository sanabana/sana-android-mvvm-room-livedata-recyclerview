package com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels;

import android.arch.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

/**
 * Created by sananda on 19/12/18.
 */

public abstract class BaseViewModel<N> extends ViewModel {

    private WeakReference<N> mNavigator;

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }
}
