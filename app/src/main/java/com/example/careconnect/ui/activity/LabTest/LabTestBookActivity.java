package com.example.careconnect.ui.activity.LabTest;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;

import java.util.Calendar;

public class LabTestBookActivity extends AppCompatActivity {

    EditText date, address;
    Button confirmBtn;

    String testName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        date = findViewById(R.id.date);
        address = findViewById(R.id.address);
        confirmBtn = findViewById(R.id.confirmBtn);

        // 🔥 GET TEST NAME
        testName = getIntent().getStringExtra("test");

        // 📅 Date Picker
        date.setFocusable(false);
        date.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            DatePickerDialog dp = new DatePickerDialog(this,
                    (view, year, month, day) -> {
                        date.setText(day + "/" + (month + 1) + "/" + year);
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );
            dp.show();
        });

        // 🔥 Confirm
        confirmBtn.setOnClickListener(v -> {

            String d = date.getText().toString();

            if (d.isEmpty()) {
                date.setError("Select Date");
                return;
            }

            // 👉 PaymentActivity call (IMPORTANT FIX)
            Intent i = new Intent(this, com.example.careconnect.ui.activity.payment.PaymentActivity.class);
            i.putExtra("labTest", testName); // 🔥 KEY FIX
            i.putExtra("date", d);
            i.putExtra("amount", 200);

            startActivity(i);
        });
    }
}