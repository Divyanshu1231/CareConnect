package com.example.careconnect.ui.activity.Medicine;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.careconnect.R;
import com.example.careconnect.model.Medicine;
import com.example.careconnect.ui.adapter.MedicineAdapter;

import java.util.*;

public class BuyMedicineActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        recycler = findViewById(R.id.recycler);

        List<Medicine> list = new ArrayList<>();

        // 🔥 Dummy Medicines
        list.add(new Medicine("Paracetamol", "Fever & Pain relief", "50"));
        list.add(new Medicine("Cough Syrup", "Cold & cough", "120"));
        list.add(new Medicine("Vitamin C", "Immunity booster", "80"));
        list.add(new Medicine("Antibiotic", "Bacterial infection", "200"));
        list.add(new Medicine("Pain Killer", "Body pain relief", "90"));

        MedicineAdapter adapter = new MedicineAdapter(list, m -> {

            Intent i = new Intent(this, BuyMedicineDetailsActivity.class);
            i.putExtra("name", m.name);
            i.putExtra("desc", m.description);
            i.putExtra("price", m.price);

            startActivity(i);
        });

        recycler.setLayoutManager(new GridLayoutManager(this, 2)); // 🔥 Grid layout
        recycler.setAdapter(adapter);
    }
}