package com.example.careconnect.ui.activity.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.ui.activity.Appointment.BookAppointmentActivity;

public class DoctorDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        TextView name = findViewById(R.id.name);
        TextView special = findViewById(R.id.special);
        TextView hospital = findViewById(R.id.hospital);
        TextView fee = findViewById(R.id.fee);
        Button bookBtn = findViewById(R.id.bookBtn);

        String n = getIntent().getStringExtra("name");
        String s = getIntent().getStringExtra("special");
        String h = getIntent().getStringExtra("hospital");
        String f = getIntent().getStringExtra("fee");

        name.setText(n);
        special.setText(s);
        hospital.setText(h);
        fee.setText("Consultation Fee: ₹" + f);

        bookBtn.setOnClickListener(v -> {
            Intent i = new Intent(this, BookAppointmentActivity.class);
            i.putExtra("name", n);
            startActivity(i);
        });
    }
}