package com.example.careconnect.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.careconnect.model.User;
import com.example.careconnect.repository.AuthRepository;

public class AuthViewModel extends AndroidViewModel {

    private AuthRepository repo;

    public AuthViewModel(@NonNull Application application) {
        super(application);
        repo = new AuthRepository(application);
    }

    public void register(User user) {
        repo.register(user);
    }

    public User login(String email, String password) {
        return repo.login(email, password);
    }

    public User checkEmail(String email) {
        return repo.checkEmail(email);
    }
}