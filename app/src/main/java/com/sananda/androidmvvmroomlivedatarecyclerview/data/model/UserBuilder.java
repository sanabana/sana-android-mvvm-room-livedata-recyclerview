package com.sananda.androidmvvmroomlivedatarecyclerview.data.model;

/**
 * Created by sananda on 20/12/18.
 */

public class UserBuilder {
    private int id;
    private String name;
    private String email;
    private String password;

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User createUser() {
        return new User(id, name, email, password);
    }
}