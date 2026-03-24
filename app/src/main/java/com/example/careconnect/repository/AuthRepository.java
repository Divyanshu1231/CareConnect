package com.example.careconnect.repository;

import android.app.Application;

import com.example.careconnect.database.AppDatabase;
import com.example.careconnect.database.UserDao;
import com.example.careconnect.model.User;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AuthRepository {

    private UserDao userDao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public AuthRepository(Application app) {
        userDao = AppDatabase.getInstance(app).userDao();
    }

    public void register(User user) {
        executor.execute(() -> userDao.register(user));
    }

    public User login(String email, String password) {
        return userDao.login(email, password);
    }

    public User checkEmail(String email) {
        return userDao.checkEmail(email);
    }
}
