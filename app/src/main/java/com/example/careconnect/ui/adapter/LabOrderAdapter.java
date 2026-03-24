package com.example.careconnect.ui.adapter;

import android.view.*;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careconnect.R;
import com.example.careconnect.model.LabOrder;

import java.util.List;

public class LabOrderAdapter extends RecyclerView.Adapter<LabOrderAdapter.VH> {

    List<LabOrder> list;

    public LabOrderAdapter(List<LabOrder> list) {
        this.list = list;
    }

    public void update(List<LabOrder> newList) {
        list = newList;
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {

        TextView testName, date, status, amount;

        public VH(@NonNull View itemView) {
            super(itemView);

            testName = itemView.findViewById(R.id.testName);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            amount = itemView.findViewById(R.id.amount);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lab_order, parent, false); // ✅ FIXED

        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {

        LabOrder o = list.get(position);

        h.testName.setText(o.testName);
        h.date.setText("Date: " + o.date);
        h.status.setText("Status: " + o.status);
        h.amount.setText("₹" + o.amount);


// 🔥 FORCE COLOR (FINAL FIX)
        h.testName.setTextColor(android.graphics.Color.WHITE);
        h.date.setTextColor(android.graphics.Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}