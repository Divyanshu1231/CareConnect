package com.example.careconnect.ui.activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.careconnect.R;
import com.example.careconnect.model.User;
import com.example.careconnect.utils.SessionManager;
import com.example.careconnect.viewmodel.AuthViewModel;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, password;
    Button register;
    AuthViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.registerBtn);


        vm = new ViewModelProvider(this).get(AuthViewModel.class);


        TextView loginRedirect = findViewById(R.id.loginRedirect);

        loginRedirect.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });

        register.setOnClickListener(v -> {
            User user = new User();
            user.name = name.getText().toString();
            user.email = email.getText().toString();
            user.password = password.getText().toString();

            vm.register(user);
            new SessionManager(this).saveUser(user.name);

            Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}