package com.example.careconnect.ui.activity.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;
import com.example.careconnect.R;
import com.example.careconnect.model.DashboardItem;
import com.example.careconnect.ui.activity.Appointment.BookAppointmentActivity;
import com.example.careconnect.ui.activity.Articles.HealthArticleActivity;
import com.example.careconnect.ui.activity.Doctor.FindDoctorActivity;
import com.example.careconnect.ui.activity.LabTest.LabTestActivity;
import com.example.careconnect.ui.activity.Medicine.BuyMedicineActivity;
import com.example.careconnect.ui.activity.Orders.OrderDetailsActivity;
import com.example.careconnect.ui.activity.Auth.LoginActivity;
import com.example.careconnect.ui.adapter.DashboardAdapter;
import com.example.careconnect.utils.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recycler = findViewById(R.id.recycler);
        TextView userName = findViewById(R.id.userName);

        SessionManager sm = new SessionManager(this);
        String name = sm.getUserName();

        userName.setText("Hello, " + name + " 👋");

        List<DashboardItem> list = new ArrayList<>();

        // Dashboard Items
        list.add(new DashboardItem("Find Doctor", R.drawable.ic_doctor));
        list.add(new DashboardItem("Lab Test", R.drawable.ic_lab));
        list.add(new DashboardItem("Buy Medicine", R.drawable.ic_medicine));
        list.add(new DashboardItem("Health Articles", R.drawable.ic_article));
        list.add(new DashboardItem("Appointments", R.drawable.ic_appointment));
        list.add(new DashboardItem("Logout", R.drawable.ic_lock_power_off)); // 🔥 Logout

        DashboardAdapter adapter = new DashboardAdapter(list, position -> {

            switch (position) {

                case 0:
                    startActivity(new Intent(this, FindDoctorActivity.class));
                    break;

                case 1:
                    startActivity(new Intent(this, LabTestActivity.class));
                    break;

                case 2:
                    startActivity(new Intent(this, BuyMedicineActivity.class));
                    break;

                case 3:
                    startActivity(new Intent(this, HealthArticleActivity.class));
                    break;

                case 4:
                    startActivity(new Intent(this, OrderDetailsActivity.class));
                    break;

                case 5: // 🔥 Logout
                    new SessionManager(this).logoutUser();
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                    break;
            }
        });

        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        recycler.setAdapter(adapter);
    }
}