package com.example.careconnect.ui.activity.Medicine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.model.Medicine;
import com.example.careconnect.utils.CartManager;

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        TextView name = findViewById(R.id.name);
        TextView desc = findViewById(R.id.desc);
        TextView price = findViewById(R.id.price);
        Button addBtn = findViewById(R.id.addBtn);
        Button cartBtn = findViewById(R.id.viewCartBtn);

        String n = getIntent().getStringExtra("name");
        String d = getIntent().getStringExtra("desc");
        String p = getIntent().getStringExtra("price");

        name.setText(n);
        desc.setText(d);
        price.setText("₹" + p);

        Medicine m = new Medicine(n, d, p);

        // 🔥 ADD TO CART (FIXED)
        addBtn.setOnClickListener(v -> {

            CartManager.addToCart(this, m);


            int size = CartManager.getCart(this).size();

            Toast.makeText(this,
                    "Added to Cart 🛒 (Items: " + size + ")",
                    Toast.LENGTH_LONG).show();

            // 👉 Direct open cart (NO BACK ISSUE)
            Intent i = new Intent(this, CartBuyMedicineActivity.class);
            startActivity(i);
        });

        // 👉 Manual cart open
        cartBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, CartBuyMedicineActivity.class));
        });
    }
}