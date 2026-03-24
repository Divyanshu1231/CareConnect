package com.example.careconnect.ui.activity.Medicine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careconnect.R;
import com.example.careconnect.model.Medicine;
import com.example.careconnect.utils.CartManager;

import java.util.List;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText address, phone;
    TextView total;
    Button orderBtn;

    int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        total = findViewById(R.id.total);
        orderBtn = findViewById(R.id.orderBtn);

        List<Medicine> cart = CartManager.getCart(this);

        // 🔥 Calculate total
        for (Medicine m : cart) {
            totalPrice += Integer.parseInt(m.price);
        }

        total.setText("Total: ₹" + totalPrice);

        // ✅ SINGLE CLICK LISTENER
        orderBtn.setOnClickListener(v -> {

            if (address.getText().toString().isEmpty()) {
                address.setError("Enter Address");
                return;
            }

            if (phone.getText().toString().isEmpty()) {
                phone.setError("Enter Phone");
                return;
            }

            // 👉 Payment screen
            Intent i = new Intent(this, com.example.careconnect.ui.activity.payment.PaymentActivity.class);
            i.putExtra("amount", totalPrice);
            startActivity(i);
        });
    }
}