package com.example.careconnect.ui.activity.LabTest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;

public class LabTestActivity extends AppCompatActivity {

    ListView list;

    String[] tests = {
            "Blood Test - ₹300",
            "Urine Test - ₹200",
            "X-Ray - ₹500",
            "MRI Scan - ₹1500"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        list = findViewById(R.id.listView);

        // 🔥 FIXED: Custom layout use
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_lab_test,   // ✅ custom XML
                R.id.testText,            // ✅ TextView id
                tests
        );

        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {

            String selectedTest = tests[position];

            Intent i = new Intent(this, LabOrderHistoryActivity.class);
            i.putExtra("test", selectedTest);
            startActivity(i);
        });
    }
}