package com.example.careconnect.ui.activity.payment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.ui.activity.Appointment.MyAppointmentsActivity;
import com.example.careconnect.ui.activity.LabTest.LabOrderActivity;
import com.example.careconnect.ui.activity.Orders.OrderDetailsActivity;
import com.example.careconnect.ui.activity.LabTest.LabOrderHistoryActivity;

public class ReceiptActivity extends AppCompatActivity {

    TextView title, date, time, amount;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        amount = findViewById(R.id.amount);
        done = findViewById(R.id.doneBtn);

        Intent i = getIntent();

        String doctor = i.getStringExtra("doctor");
        String labTest = i.getStringExtra("labTest");
        String d = i.getStringExtra("date");
        String t = i.getStringExtra("time");
        int amt = i.getIntExtra("amount", 0);

        // 🔥 CASE HANDLING
        if (doctor != null) {
            title.setText("Doctor Appointment 🩺");
            date.setText("Date: " + d);
            time.setText("Time: " + t);

        } else if (labTest != null) {
            title.setText("Lab Test 🧪");
            date.setText("Date: " + d);
            time.setText("");

        } else {
            title.setText("Medicine Order 🛒");
            date.setText("Delivery: 2-3 Days");
            time.setText("");
        }

        amount.setText("Paid: ₹" + amt);

        // 🔥 DONE BUTTON
        done.setOnClickListener(v -> {

            if (doctor != null) {
                startActivity(new Intent(this, MyAppointmentsActivity.class));
            } else if (labTest != null) {
                startActivity(new Intent(this, LabOrderActivity.class));
            } else {
                startActivity(new Intent(this, OrderDetailsActivity.class));
            }

            finish();
        });
    }
}