package com.example.careconnect.ui.adapter;

import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.recyclerview.widget.RecyclerView;

import com.example.careconnect.R;
import com.example.careconnect.model.Doctor;
import com.example.careconnect.ui.activity.Doctor.DoctorDetailsActivity;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.VH> {

    List<Doctor> list;
    Context context;

    public DoctorAdapter(Context context, List<Doctor> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup p, int v) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_doctor, p, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH h, int i) {

        Doctor d = list.get(i);

        h.name.setText(d.name);
        h.special.setText(d.specialization);
        h.hospital.setText(d.hospital);
        h.fee.setText("₹" + d.fee);

        // 🔥 CLICK → DETAILS
        h.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DoctorDetailsActivity.class);
            intent.putExtra("name", d.name);
            intent.putExtra("special", d.specialization);
            intent.putExtra("hospital", d.hospital);
            intent.putExtra("fee", d.fee);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {

        TextView name, special, hospital, fee;

        VH(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            special = v.findViewById(R.id.special);
            hospital = v.findViewById(R.id.hospital);
            fee = v.findViewById(R.id.fee);
        }
    }
}