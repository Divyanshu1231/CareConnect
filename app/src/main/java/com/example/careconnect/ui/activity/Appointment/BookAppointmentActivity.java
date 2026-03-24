package com.example.careconnect.ui.activity.Appointment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    TextView doctorName;
    EditText date, time;
    Button bookBtn;

    String docName; // 🔥 GLOBAL

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        // 🔥 Bind views
        doctorName = findViewById(R.id.doctorName);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        bookBtn = findViewById(R.id.bookBtn);

        // 🔥 Null safety
        if (doctorName == null || date == null || time == null || bookBtn == null) {
            Toast.makeText(this, "UI Error ❌", Toast.LENGTH_LONG).show();
            return;
        }

        // 🔥 Get doctor name
        docName = getIntent().getStringExtra("name");
        if (docName == null) docName = "Doctor";

        doctorName.setText("Doctor: " + docName);

        // 📅 Date Picker
        date.setFocusable(false);
        date.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            DatePickerDialog dp = new DatePickerDialog(this,
                    (view, year, month, day) -> {
                        String formattedDate = String.format("%02d/%02d/%04d",
                                day, month + 1, year);
                        date.setText(formattedDate);
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );

            dp.getDatePicker().setMinDate(System.currentTimeMillis());
            dp.show();
        });

        // ⏰ Time Picker
        time.setFocusable(false);
        time.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            TimePickerDialog tp = new TimePickerDialog(this,
                    (view, hour, minute) -> {

                        String amPm = (hour >= 12) ? "PM" : "AM";
                        int hour12 = hour % 12;
                        if (hour12 == 0) hour12 = 12;

                        String formattedTime = String.format("%02d:%02d %s",
                                hour12, minute, amPm);

                        time.setText(formattedTime);
                    },
                    c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),
                    false
            );

            tp.show();
        });

        // 🔥 Confirm Appointment
        bookBtn.setOnClickListener(v -> {

            String d = date.getText().toString().trim();
            String t = time.getText().toString().trim();

            if (d.isEmpty()) {
                date.setError("Select Date");
                return;
            }

            if (t.isEmpty()) {
                time.setError("Select Time");
                return;
            }

            // 👉 ONLY start payment
            Intent i = new Intent(this, com.example.careconnect.ui.activity.payment.PaymentActivity.class);
            i.putExtra("doctor", docName);
            i.putExtra("date", d);
            i.putExtra("time", t);
            i.putExtra("amount", 300);

            startActivity(i);

            // ❌ NO toast
            // ❌ NO MyAppointments navigation
            // ❌ NO try-catch needed
        });
    }
}