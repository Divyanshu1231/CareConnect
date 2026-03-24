package com.example.careconnect.ui.activity.LabTest;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import com.example.careconnect.R;
import com.example.careconnect.model.LabOrder;
import com.example.careconnect.ui.adapter.LabOrderAdapter;
import com.example.careconnect.viewmodel.LabOrderViewModel;

import java.util.ArrayList;
import java.util.List;

public class LabOrderActivity extends AppCompatActivity {

    RecyclerView recycler;
    LabOrderAdapter adapter;
    LabOrderViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_orders);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // 🔥 ViewModel init
        vm = new ViewModelProvider(this).get(LabOrderViewModel.class);

        // 🔥 Empty adapter
        adapter = new LabOrderAdapter(new ArrayList<>());
        recycler.setAdapter(adapter);

        // 🔥 Observe data
        vm.getAll().observe(this, list -> {

            if (list == null || list.isEmpty()) {
                Toast.makeText(this, "No Lab Orders ❌", Toast.LENGTH_SHORT).show();
                adapter.update(new ArrayList<>());
                return;
            }

            adapter.update(list);

            // 👉 Debug
            Toast.makeText(this, "Lab Orders: " + list.size(), Toast.LENGTH_SHORT).show();
        });
    }
}