package com.example.careconnect.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.careconnect.model.User;

@Dao
public interface UserDao {

    @Insert
    void register(User user);

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    User login(String email, String password);

    @Query("SELECT * FROM users WHERE email = :email")
    User checkEmail(String email);

    @Query("UPDATE users SET password = :newPass WHERE email = :email")
    void updatePassword(String email, String newPass);
}
