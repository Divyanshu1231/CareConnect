package com.example.careconnect.ui.activity.Doctor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.careconnect.R;
import com.example.careconnect.model.Doctor;
import com.example.careconnect.ui.adapter.DoctorAdapter;

import java.util.*;

public class DoctorListActivity extends AppCompatActivity {

    RecyclerView recycler;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        recycler = findViewById(R.id.recycler);
        title = findViewById(R.id.title);

        String category = getIntent().getStringExtra("category");
        title.setText(category + " 👨‍⚕️");

        List<Doctor> list = new ArrayList<>();

        // 🔥 Category wise data
        switch (category) {

            case "Family Physician":
                list.add(new Doctor("Dr. Sharma", category, "City Hospital", "300"));
                list.add(new Doctor("Dr. Verma", category, "Apollo", "400"));
                break;

            case "Dietician":
                list.add(new Doctor("Dr. Neha", category, "Wellness Clinic", "500"));
                list.add(new Doctor("Dr. Riya", category, "Health Plus", "450"));
                break;

            case "Dentist":
                list.add(new Doctor("Dr. Singh", category, "Dental Care", "250"));
                list.add(new Doctor("Dr. Khan", category, "Smile Clinic", "300"));
                break;

            case "Surgeon":
                list.add(new Doctor("Dr. Arjun", category, "AIIMS", "800"));
                list.add(new Doctor("Dr. Mehta", category, "Medanta", "900"));
                break;

            case "Cardiologist":
                list.add(new Doctor("Dr. Heart", category, "Apollo", "1000"));
                list.add(new Doctor("Dr. Raj", category, "Fortis", "1200"));
                break;
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new DoctorAdapter(this, list));
        //recycler.setAdapter(new DoctorAdapter(list));
    }
}