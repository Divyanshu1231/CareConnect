package com.example.careconnect.ui.activity.LabTest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;

public class LabOrderHistoryActivity extends AppCompatActivity {

    TextView testName;
    Button bookBtn;

    String test;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        testName = findViewById(R.id.testName);
        bookBtn = findViewById(R.id.bookBtn);

        test = getIntent().getStringExtra("test");
        testName.setText(test);

        // 🔥 Extract price
        if (test.contains("300")) price = 300;
        else if (test.contains("200")) price = 200;
        else if (test.contains("500")) price = 500;
        else price = 1500;

        bookBtn.setOnClickListener(v -> {

            Intent i = new Intent(this, LabTestBookActivity.class);
            i.putExtra("test", test);
            i.putExtra("amount", price);
            startActivity(i);
        });
    }
}