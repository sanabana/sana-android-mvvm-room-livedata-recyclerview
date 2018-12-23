package com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels;

import com.sananda.androidmvvmroomlivedatarecyclerview.navigators.MainNavigator;

/**
 * Created by sananda on 19/12/18.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public void onLoginClicked() {
        getNavigator().login();
    }

    public void onRegistrationClicked() {
       getNavigator().register();
    }
    }
