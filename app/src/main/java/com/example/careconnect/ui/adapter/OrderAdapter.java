package com.example.careconnect.ui.adapter;

import android.view.*;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careconnect.R;
import com.example.careconnect.model.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.VH> {

    List<Order> list;

    public OrderAdapter(List<Order> list) {
        this.list = list;
    }

    public void update(List<Order> l) {
        list = l;
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView title, date, status, amount;

        VH(View v) {
            super(v);
            title = v.findViewById(R.id.orderTitle);
            date = v.findViewById(R.id.orderDate);
            status = v.findViewById(R.id.orderStatus);
            amount = v.findViewById(R.id.orderAmount);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int vType) {
        View v = LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_order, p, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int i) {
        Order o = list.get(i);

        h.title.setText(o.title);
        h.date.setText(o.date);
        h.status.setText(o.status);
        h.amount.setText("₹" + o.amount);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}