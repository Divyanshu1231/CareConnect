package com.example.careconnect.ui.activity.Auth;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.database.AppDatabase;

public class ResetActivity extends AppCompatActivity {

    EditText newPassword, confirmPassword;
    Button updateBtn;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        newPassword = findViewById(R.id.newPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
        updateBtn = findViewById(R.id.updateBtn);

        // 🔥 email from Forgot screen
        email = getIntent().getStringExtra("email");

        updateBtn.setOnClickListener(v -> {

            String pass = newPassword.getText().toString().trim();
            String confirm = confirmPassword.getText().toString().trim();

            // 🔥 validation
            if (pass.isEmpty()) {
                newPassword.setError("Enter new password");
                return;
            }

            if (confirm.isEmpty()) {
                confirmPassword.setError("Confirm password");
                return;
            }

            if (!pass.equals(confirm)) {
                confirmPassword.setError("Passwords do not match ❌");
                return;
            }

            if (pass.length() < 6) {
                newPassword.setError("Minimum 6 characters");
                return;
            }

            // 🔥 update in DB
            new Thread(() -> {

                AppDatabase
                        .getInstance(getApplicationContext())
                        .userDao()
                        .updatePassword(email, pass);

                runOnUiThread(() -> {
                    Toast.makeText(this, "Password Updated ✅", Toast.LENGTH_SHORT).show();
                    finish(); // वापस login screen
                });

            }).start();
        });
    }
}