package com.example.careconnect.ui.activity.Appointment;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import com.example.careconnect.R;
import com.example.careconnect.ui.adapter.AppointmentAdapter;
import com.example.careconnect.viewmodel.AppointmentViewModel;

import java.util.ArrayList;

public class MyAppointmentsActivity extends AppCompatActivity {

    RecyclerView recycler;
    AppointmentViewModel vm;
    AppointmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // ✅ FIRST ViewModel init
        vm = new ViewModelProvider(this).get(AppointmentViewModel.class);

        // ✅ THEN adapter
        adapter = new AppointmentAdapter(new ArrayList<>(), vm);
        recycler.setAdapter(adapter);

        // ✅ SINGLE observer
        vm.getAll().observe(this, list -> {

            if (list == null || list.isEmpty()) {
                Toast.makeText(this, "No Appointments ❌", Toast.LENGTH_SHORT).show();
                adapter.updateList(new ArrayList<>());
                return;
            }

            adapter.updateList(list);
        });
    }
}