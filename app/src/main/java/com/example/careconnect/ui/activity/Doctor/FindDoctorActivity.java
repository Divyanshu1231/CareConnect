package com.example.careconnect.ui.activity.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;

public class FindDoctorActivity extends AppCompatActivity {

    LinearLayout family, dietician, dentist, surgeon, cardio, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        initViews();
        setClickListeners();
    }

    // 🔥 Initialize Views
    private void initViews() {
        family = findViewById(R.id.family);
        dietician = findViewById(R.id.dietician);
        dentist = findViewById(R.id.dentist);
        surgeon = findViewById(R.id.surgeon);
        cardio = findViewById(R.id.cardio);
        back = findViewById(R.id.back);
    }

    // 🔥 Click Handling
    private void setClickListeners() {

        setClick(family, "Family Physician");
        setClick(dietician, "Dietician");
        setClick(dentist, "Dentist");
        setClick(surgeon, "Surgeon");
        setClick(cardio, "Cardiologist");

        if (back != null) {
            back.setOnClickListener(v -> finish());
        }
    }

    // 🔥 Reusable Click Method
    private void setClick(LinearLayout layout, String category) {

        if (layout != null) {
            layout.setOnClickListener(v -> {

                // 🔥 छोटा सा click effect
                v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(80)
                        .withEndAction(() -> {
                            v.animate().scaleX(1f).scaleY(1f).setDuration(80);
                            openDoctor(category);
                        });
            });
        }
    }

    // 🔥 Open Doctor List
    private void openDoctor(String category) {
        Intent i = new Intent(this, DoctorListActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }
}