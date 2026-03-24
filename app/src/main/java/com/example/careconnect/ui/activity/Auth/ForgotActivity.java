package com.example.careconnect.ui.activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.careconnect.R;
import com.example.careconnect.database.AppDatabase;
import com.example.careconnect.model.User;

public class ForgotActivity extends AppCompatActivity {

    EditText email;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        email = findViewById(R.id.email);
        reset = findViewById(R.id.resetBtn);

        reset.setOnClickListener(v -> {

            String mail = email.getText().toString().trim();

            if (mail.isEmpty()) {
                email.setError("Enter Email");
                return;
            }

            new Thread(() -> {

                User user = AppDatabase
                        .getInstance(getApplicationContext())
                        .userDao()
                        .checkEmail(mail);

                runOnUiThread(() -> {

                    if (user == null) {
                        Toast.makeText(this, "Email not registered ❌", Toast.LENGTH_SHORT).show();
                    } else {
                        // 👉 Open Reset Screen
                        Intent i = new Intent(this, ResetActivity.class);
                        i.putExtra("email", mail);
                        startActivity(i);
                    }

                });

            }).start();
        });
    }
}