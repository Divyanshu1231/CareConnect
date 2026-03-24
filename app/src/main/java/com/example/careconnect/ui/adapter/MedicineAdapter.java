package com.example.careconnect.ui.adapter;

import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careconnect.R;
import com.example.careconnect.model.Medicine;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    List<Medicine> list;
    OnClick listener;

    public interface OnClick {
        void onClick(Medicine m);
    }

    public MedicineAdapter(List<Medicine> list, OnClick listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medicine, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int i) {
        Medicine m = list.get(i);

        h.name.setText(m.name);
        h.desc.setText(m.description);
        h.price.setText("₹" + m.price);

        h.itemView.setOnClickListener(v -> listener.onClick(m));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc, price;

        ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            desc = v.findViewById(R.id.desc);
            price = v.findViewById(R.id.price);
        }
    }
}