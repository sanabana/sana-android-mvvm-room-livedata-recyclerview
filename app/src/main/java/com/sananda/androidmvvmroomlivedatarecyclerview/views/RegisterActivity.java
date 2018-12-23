package com.sananda.androidmvvmroomlivedatarecyclerview.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.sananda.androidmvvmroomlivedatarecyclerview.R;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.local.db.AppDatabase;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.UserBuilder;
import com.sananda.androidmvvmroomlivedatarecyclerview.databinding.ActivityRegisterBinding;
import com.sananda.androidmvvmroomlivedatarecyclerview.navigators.RegistrationNavigator;
import com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels.RegistrationViewModel;

import javax.inject.Inject;

/**
 * Created by sananda on 19/12/18.
 */

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegistrationViewModel> implements RegistrationNavigator {

    @Inject
    RegistrationViewModel mRegistrationViewModel;
    private ActivityRegisterBinding mActivityRegisterBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegistrationViewModel getViewModel() {
        return mRegistrationViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityRegisterBinding = getViewDataBinding();
        mRegistrationViewModel.setNavigator(this);
    }

    @Override
    public void login() {
        Intent intent = MainActivity.newIntent(RegisterActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void register() {
        String name = mActivityRegisterBinding.etName.getText().toString().trim();
        String email = mActivityRegisterBinding.etEmail.getText().toString().trim();
        String password = mActivityRegisterBinding.etPassword.getText().toString().trim();
        String confirm_password = mActivityRegisterBinding.etConfrmPassword.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, getString(R.string.rqrd_name), Toast.LENGTH_SHORT).show();
        } else if (email.isEmpty()) {
            Toast.makeText(this, getString(R.string.rqrd_email), Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(this, getString(R.string.rqrd_pass), Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirm_password)) {
            Toast.makeText(this, getString(R.string.msg_pass_mismatch), Toast.LENGTH_SHORT).show();
        } else {
            AppDatabase appDatabase = AppDatabase.getInMemoryDatabase(this);

            if (email != null && !email.isEmpty()) {
                if (appDatabase.userDao().findByEmail(email) != null) {
                    Toast.makeText(this, getString(R.string.msg_email_exists), Toast.LENGTH_SHORT).show();
                } else {
                    User user = new UserBuilder().
                            setName(mActivityRegisterBinding.etName.getText().toString().trim()).
                            setEmail(mActivityRegisterBinding.etEmail.getText().toString().trim()).
                            setPassword(mActivityRegisterBinding.etPassword.getText().toString().trim()).
                            createUser();

                    appDatabase.userDao().insert(user);

                    Intent intent = MainActivity.newIntent(this);
                    startActivity(intent);
                    finish();

                }
            }
        }
    }
}
