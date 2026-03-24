package com.example.careconnect.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        sp = context.getSharedPreferences("medivision_app", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    // Save login
    public void loginUser() {
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    // Check login
    public boolean isLoggedIn() {
        return sp.getBoolean("isLoggedIn", false);
    }

    // Logout
    public void logoutUser() {
        editor.clear();
        editor.apply();
    }
    public void saveUser(String name) {
        editor.putString("username", name);
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    public String getUserName() {
        return sp.getString("username", "User");
    }
}