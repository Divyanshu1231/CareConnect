package com.example.careconnect.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.careconnect.R;
import com.example.careconnect.model.Doctor;
import com.example.careconnect.ui.activity.Appointment.BookAppointmentActivity;
import com.example.careconnect.ui.activity.Doctor.DoctorDetailsActivity;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.VH> {

    private final List<Doctor> list;
    private final Context context;

    public DoctorAdapter(Context context, List<Doctor> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Doctor doctor = list.get(position);

        holder.name.setText(doctor.name);
        holder.special.setText(doctor.specialization);
        holder.hospital.setText(doctor.hospital);
        holder.fee.setText("\u20b9" + doctor.fee);

        if (holder.experience != null) {
            holder.experience.setText(doctor.experience + " exp");
        }

        if (holder.rating != null) {
            holder.rating.setText("\u2605 " + doctor.rating);
        }

        if (holder.doctorImage != null && doctor.image != 0) {
            holder.doctorImage.setImageResource(doctor.image);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DoctorDetailsActivity.class);
            intent.putExtra("name", doctor.name);
            intent.putExtra("special", doctor.specialization);
            intent.putExtra("hospital", doctor.hospital);
            intent.putExtra("fee", doctor.fee);
            intent.putExtra("experience", doctor.experience);
            intent.putExtra("rating", doctor.rating);
            intent.putExtra("image", doctor.image);
            context.startActivity(intent);
        });

        if (holder.bookBtn != null) {
            holder.bookBtn.setOnClickListener(v -> {
                Intent intent = new Intent(context, BookAppointmentActivity.class);
                intent.putExtra("name", doctor.name);
                intent.putExtra("fee", doctor.fee);
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class VH extends RecyclerView.ViewHolder {

        TextView name;
        TextView special;
        TextView hospital;
        TextView fee;
        TextView experience;
        TextView rating;
        Button bookBtn;
        ImageView doctorImage;

        VH(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            special = view.findViewById(R.id.special);
            hospital = view.findViewById(R.id.hospital);
            fee = view.findViewById(R.id.fee);
            experience = view.findViewById(R.id.experience);
            rating = view.findViewById(R.id.rating);
            bookBtn = view.findViewById(R.id.bookBtn);
            doctorImage = view.findViewById(R.id.doctorImage);
        }
    }
}
