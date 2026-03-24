package com.example.careconnect.ui.activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.careconnect.R;
import com.example.careconnect.model.User;
import com.example.careconnect.ui.activity.home.HomeActivity;
import com.example.careconnect.utils.SessionManager;
import com.example.careconnect.viewmodel.AuthViewModel;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    AuthViewModel vm;
    TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        TextView forgot = findViewById(R.id.forgotText);

        forgot.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
        });
        registerText = findViewById(R.id.registerText);

        registerText.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        vm = new ViewModelProvider(this).get(AuthViewModel.class);

        login.setOnClickListener(v -> {
            new Thread(() -> {
                User user = vm.login(
                        email.getText().toString(),
                        password.getText().toString()
                );

                runOnUiThread(() -> {
                    if (user != null) {
                        new SessionManager(this).loginUser();
                        new SessionManager(this).saveUser(user.name);
                        startActivity(new Intent(this, HomeActivity.class));
                    } else {
                        Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }
                });
            }).start();
        });
    }
}