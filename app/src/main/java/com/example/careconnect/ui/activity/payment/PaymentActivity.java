package com.example.careconnect.ui.activity.payment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.careconnect.R;
import com.example.careconnect.model.Appointment;
import com.example.careconnect.model.Order;
import com.example.careconnect.model.LabOrder;
import com.example.careconnect.viewmodel.AppointmentViewModel;
import com.example.careconnect.viewmodel.OrderViewModel;
import com.example.careconnect.viewmodel.LabOrderViewModel;

public class PaymentActivity extends AppCompatActivity {

    ImageView icon;
    TextView text;

    String doctor, date, time, labTest;
    int amount;

    AppointmentViewModel appointmentVM;
    OrderViewModel orderVM;
    LabOrderViewModel labVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        icon = findViewById(R.id.successIcon);
        text = findViewById(R.id.successText);

        appointmentVM = new ViewModelProvider(this).get(AppointmentViewModel.class);
        orderVM = new ViewModelProvider(this).get(OrderViewModel.class);
        labVM = new ViewModelProvider(this).get(LabOrderViewModel.class);

        // 🔥 GET DATA
        doctor = getIntent().getStringExtra("doctor");
        labTest = getIntent().getStringExtra("labTest");
        date = getIntent().getStringExtra("date");
        time = getIntent().getStringExtra("time");
        amount = getIntent().getIntExtra("amount", 300);

        // 🎉 Animation
        icon.animate().scaleX(1).scaleY(1).setDuration(600).start();

        new Handler().postDelayed(() -> {
            text.animate().alpha(1).setDuration(500).start();
        }, 500);

        // 🔥 SAVE LOGIC (MAIN FIX)
        if (doctor != null) {
            Appointment a = new Appointment();
            a.doctorName = doctor;
            a.date = date;
            a.time = time;
            a.status = "Upcoming";
            appointmentVM.insert(a);

        } else if (labTest != null) {
            LabOrder o = new LabOrder();
            o.testName = labTest;
            o.date = date;
            o.status = "Booked";
            o.amount = amount;

            labVM.insert(o); // 🔥 THIS WAS MISSING

        } else {
            Order o = new Order();
            o.title = "Medicine Order 🛒";
            o.date = "Today";
            o.status = "Ordered";
            o.amount = amount;

            orderVM.insert(o);
        }

        // ⏳ Go to receipt
        new Handler().postDelayed(() -> {

            Intent i = new Intent(this, ReceiptActivity.class);
            i.putExtra("doctor", doctor);
            i.putExtra("labTest", labTest);
            i.putExtra("date", date);
            i.putExtra("time", time);
            i.putExtra("amount", amount);

            startActivity(i);
            finish();

        }, 2000);
    }
}