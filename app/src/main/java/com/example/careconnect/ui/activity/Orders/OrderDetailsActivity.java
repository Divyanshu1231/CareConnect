package com.example.careconnect.ui.activity.Orders;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import com.example.careconnect.R;
import com.example.careconnect.model.Order;
import com.example.careconnect.ui.adapter.OrderAdapter;
import com.example.careconnect.viewmodel.OrderViewModel;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {

    RecyclerView recycler;
    OrderAdapter adapter;
    OrderViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // 🔥 ViewModel init
        vm = new ViewModelProvider(this).get(OrderViewModel.class);

        // 🔥 Empty adapter
        adapter = new OrderAdapter(new ArrayList<>());
        recycler.setAdapter(adapter);

        // 🔥 Observe DB
        vm.getAll().observe(this, list -> {

            if (list == null || list.isEmpty()) {
                Toast.makeText(this, "No Orders ❌", Toast.LENGTH_SHORT).show();
                adapter.update(new ArrayList<>());
                return;
            }

            adapter.update(list);

            // 👉 Debug
            Toast.makeText(this, "Orders: " + list.size(), Toast.LENGTH_SHORT).show();
        });
    }
}