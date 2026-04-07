package com.example.careconnect.ui.activity.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;

public class FindDoctorActivity extends AppCompatActivity {

    LinearLayout family, dietician, dentist, surgeon, cardio, back;

    private long lastClickTime = 0; // 🔥 double click prevention

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        initViews();
        setClickListeners();
    }

    // 🔹 Initialize Views
    private void initViews() {
        family = findViewById(R.id.family);
        dietician = findViewById(R.id.dietician);
        dentist = findViewById(R.id.dentist);
        surgeon = findViewById(R.id.surgeon);
        cardio = findViewById(R.id.cardio);
        back = findViewById(R.id.back);
    }

    // 🔹 Click Handling
    private void setClickListeners() {

        setClick(family, "Family Physician");
        setClick(dietician, "Dietician");
        setClick(dentist, "Dentist");
        setClick(surgeon, "Surgeon");
        setClick(cardio, "Cardiologist");

        if (back != null) {
            back.setOnClickListener(v -> onBackPressed());
        }
    }

    // 🔹 Reusable Click Method
    private void setClick(LinearLayout layout, String category) {

        if (layout != null) {
            layout.setOnClickListener(v -> {

                // 🔥 Prevent fast double click
                if (SystemClock.elapsedRealtime() - lastClickTime < 800) return;
                lastClickTime = SystemClock.elapsedRealtime();

                // 🔥 Click animation
                v.animate().scaleX(0.94f).scaleY(0.94f).setDuration(100)
                        .withEndAction(() -> {
                            v.animate().scaleX(1f).scaleY(1f).setDuration(100);

                            // 🔥 Feedback
                            Toast.makeText(this, category, Toast.LENGTH_SHORT).show();

                            openDoctor(category);
                        });
            });
        }
    }

    // 🔹 Open Doctor List
    private void openDoctor(String category) {
        Intent i = new Intent(this, DoctorListActivity.class);
        i.putExtra("category", category);
        startActivity(i);

        // 🔥 Smooth transition (optional)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    // 🔹 Back press behavior
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}