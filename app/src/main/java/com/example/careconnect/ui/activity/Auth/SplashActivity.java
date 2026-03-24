package com.example.careconnect.ui.activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.ui.activity.home.HomeActivity;
import com.example.careconnect.utils.SessionManager;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 🔥 IMPORTANT (layout load)
        setContentView(R.layout.activity_splash);

        // 🔥 bind view
        logo = findViewById(R.id.logo);

        // 🎉 animation
        logo.setScaleX(0f);
        logo.setScaleY(0f);

        logo.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(800)
                .start();

        // ⏳ delay
        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            SessionManager sm = new SessionManager(this);

            if (sm.isLoggedIn()) {
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                startActivity(new Intent(this, LoginActivity.class));
            }

            finish();

        }, 2000);
    }
}