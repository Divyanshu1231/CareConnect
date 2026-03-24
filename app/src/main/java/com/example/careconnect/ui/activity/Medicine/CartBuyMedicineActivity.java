package com.example.careconnect.ui.activity.Medicine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.model.Medicine;
import com.example.careconnect.utils.CartManager;

import java.util.*;

public class CartBuyMedicineActivity extends AppCompatActivity {

    ListView listView;
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_buy_medicine);

        listView = findViewById(R.id.list);
        orderBtn = findViewById(R.id.orderBtn);

        List<Medicine> cart = CartManager.getCart(this);

        // 🔥 DEBUG
        Toast.makeText(this,
                "Cart size: " + cart.size(),
                Toast.LENGTH_LONG).show();

        List<String> items = new ArrayList<>();

        if (cart.isEmpty()) {
            items.add("Cart is empty ❌");
        } else {
            for (Medicine m : cart) {
                items.add(m.name + " - ₹" + m.price);
            }
        }

        // ✅ FIXED ADAPTER (custom layout)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_cart,   // 👈 custom layout
                R.id.text,
                items
        );

        listView.setAdapter(adapter);

        orderBtn.setOnClickListener(v -> {

            if (cart.isEmpty()) {
                Toast.makeText(this, "Cart Empty ❌", Toast.LENGTH_SHORT).show();
                return;
            }

            startActivity(new Intent(this, BuyMedicineBookActivity.class));
        });
    }
}