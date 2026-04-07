package com.example.careconnect.ui.activity.Doctor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.ui.activity.Appointment.BookAppointmentActivity;

public class DoctorDetailsActivity extends AppCompatActivity {

    TextView name, special, hospital, fee, experience, rating;
    Button bookBtn;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        // 🔹 Init views
        name = findViewById(R.id.name);
        special = findViewById(R.id.special);
        hospital = findViewById(R.id.hospital);
        fee = findViewById(R.id.fee);
        bookBtn = findViewById(R.id.bookBtn);

        experience = findViewById(R.id.experience);
        rating = findViewById(R.id.rating);

        // 🔹 Get data
        Intent intent = getIntent();

        String n = intent.getStringExtra("name");
        String s = intent.getStringExtra("special");
        String h = intent.getStringExtra("hospital");
        String f = intent.getStringExtra("fee");

        String exp = intent.getStringExtra("experience");
        String rate = intent.getStringExtra("rating");

        // 🔥 Null safety
        if (n == null) n = "Doctor Name";
        if (s == null) s = "Specialist";
        if (h == null) h = "Hospital";
        if (f == null) f = "0";

        // 🔥 FINAL variables (lambda fix)
        final String finalName = n;
        final String finalFee = f;

        // 🔹 Set UI
        name.setText(finalName);
        special.setText("Specialization: " + s);
        hospital.setText("Hospital: " + h);
        fee.setText("Consultation Fee: ₹" + finalFee);

        if (experience != null && exp != null) {
            experience.setText("Experience: " + exp);
        }

        if (rating != null && rate != null) {
            rating.setText("Rating: ⭐ " + rate);
        }

        // 🔹 Book button
        bookBtn.setOnClickListener(v -> {
            Intent i = new Intent(this, BookAppointmentActivity.class);
            i.putExtra("name", finalName);
            i.putExtra("fee", finalFee); // ✅ FIXED
            startActivity(i);
        });

        // 🔹 Toolbar back
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Doctor Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}