package com.example.careconnect.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careconnect.R;
import com.example.careconnect.model.Appointment;
import com.example.careconnect.viewmodel.AppointmentViewModel;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    List<Appointment> list;
    AppointmentViewModel vm;

    public AppointmentAdapter(List<Appointment> list, AppointmentViewModel vm) {
        this.list = list;
        this.vm = vm;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateList(List<Appointment> newList) {
        this.list = newList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, date, time, status;
        Button deleteBtn;

        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            date = v.findViewById(R.id.date);
            time = v.findViewById(R.id.time);
            status = v.findViewById(R.id.status);
            deleteBtn = v.findViewById(R.id.deleteBtn);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appointment, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int i) {

        Appointment a = list.get(i);

        h.name.setText(a.doctorName);
        h.date.setText("📅 " + a.date);
        h.time.setText("⏰ " + a.time);
        h.status.setText("Status: " + a.status);

        // 🔥 Auto update status (basic)
        if (a.date.equals("today")) {
            a.status = "Completed";
        }

        // ❌ Cancel
        h.deleteBtn.setOnClickListener(v -> {
            vm.delete(a);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}