package com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels;

import com.sananda.androidmvvmroomlivedatarecyclerview.navigators.RegistrationNavigator;

/**
 * Created by sananda on 19/12/18.
 */

public class RegistrationViewModel extends BaseViewModel<RegistrationNavigator> {

    public void onLoginClicked() {
        getNavigator().login();
    }

    public void onRegistrationClicked() {
       getNavigator().register();
    }
    }
