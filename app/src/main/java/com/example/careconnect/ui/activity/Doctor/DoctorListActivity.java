package com.example.careconnect.ui.activity.Doctor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.careconnect.R;
import com.example.careconnect.model.Doctor;
import com.example.careconnect.ui.adapter.DoctorAdapter;

import java.util.*;

public class DoctorListActivity extends AppCompatActivity {

    RecyclerView recycler;
    TextView title;
    List<Doctor> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        recycler = findViewById(R.id.recycler);
        title = findViewById(R.id.title);

        String category = getIntent().getStringExtra("category");
        if (category == null) category = "Doctors";

        title.setText(category + " 👨‍⚕️");

        list = new ArrayList<>();

        switch (category) {

            case "Family Physician":
                list.add(new Doctor("Dr. Rajesh Sharma", category, "City Care Hospital", "300"));
                list.add(new Doctor("Dr. Amit Verma", category, "LifeLine Clinic", "350"));
                list.add(new Doctor("Dr. Sunil Mishra", category, "Metro Health", "320"));
                list.add(new Doctor("Dr. Deepak Yadav", category, "Green Valley Hospital", "280"));
                list.add(new Doctor("Dr. Manoj Tiwari", category, "Urban Clinic", "300"));
                list.add(new Doctor("Dr. Rakesh Singh", category, "Prime Care", "400"));
                list.add(new Doctor("Dr. Vinod Gupta", category, "City Health Center", "330"));
                list.add(new Doctor("Dr. Pankaj Saxena", category, "Family Care Hub", "290"));
                list.add(new Doctor("Dr. Kunal Jain", category, "Sunrise Clinic", "310"));
                list.add(new Doctor("Dr. Sandeep Roy", category, "Care Plus", "360"));
                break;

            case "Dietician":
                list.add(new Doctor("Dr. Neha Kapoor", category, "NutriLife Clinic", "500"));
                list.add(new Doctor("Dr. Riya Malhotra", category, "Health First", "550"));
                list.add(new Doctor("Dr. Sneha Arora", category, "FitCare Center", "520"));
                list.add(new Doctor("Dr. Kavita Sharma", category, "Wellness Hub", "480"));
                list.add(new Doctor("Dr. Aditi Mehra", category, "Healthy Living Clinic", "600"));
                list.add(new Doctor("Dr. Pooja Bansal", category, "NutriCare", "530"));
                list.add(new Doctor("Dr. Anjali Verma", category, "Diet Plus", "510"));
                list.add(new Doctor("Dr. Shweta Jain", category, "SlimFit Clinic", "570"));
                list.add(new Doctor("Dr. Tanya Gupta", category, "Wellbeing Center", "490"));
                list.add(new Doctor("Dr. Priya Sinha", category, "Balanced Diet Clinic", "560"));
                break;

            case "Dentist":
                list.add(new Doctor("Dr. Rohit Singh", category, "Smile Dental Care", "250"));
                list.add(new Doctor("Dr. Imran Khan", category, "Bright Teeth Clinic", "300"));
                list.add(new Doctor("Dr. Akash Verma", category, "Perfect Smile", "270"));
                list.add(new Doctor("Dr. Nitin Gupta", category, "Dental Hub", "320"));
                list.add(new Doctor("Dr. Saurabh Jain", category, "ToothCare Center", "280"));
                list.add(new Doctor("Dr. Vivek Mishra", category, "Smile Zone", "260"));
                list.add(new Doctor("Dr. Aditya Sharma", category, "White Teeth Clinic", "290"));
                list.add(new Doctor("Dr. Rahul Mehta", category, "Dental Solutions", "310"));
                list.add(new Doctor("Dr. Varun Kapoor", category, "Oral Care Clinic", "275"));
                list.add(new Doctor("Dr. Karan Yadav", category, "Smile Studio", "295"));
                break;

            case "Surgeon":
                list.add(new Doctor("Dr. Arjun Reddy", category, "AIIMS Delhi", "800"));
                list.add(new Doctor("Dr. Vikram Mehta", category, "Medanta Hospital", "900"));
                list.add(new Doctor("Dr. Rajiv Kapoor", category, "Fortis Hospital", "850"));
                list.add(new Doctor("Dr. Sameer Khanna", category, "Max Hospital", "920"));
                list.add(new Doctor("Dr. Anil Sharma", category, "Apollo Hospital", "870"));
                list.add(new Doctor("Dr. Deepak Chauhan", category, "Global Hospital", "910"));
                list.add(new Doctor("Dr. Suresh Nair", category, "Care Hospital", "880"));
                list.add(new Doctor("Dr. Manoj Pillai", category, "Sunshine Hospital", "930"));
                list.add(new Doctor("Dr. Harish Rao", category, "Metro Hospital", "860"));
                list.add(new Doctor("Dr. Ashok Iyer", category, "Prime Hospital", "940"));
                break;

            case "Cardiologist":
                list.add(new Doctor("Dr. Rajesh Heart", category, "Apollo Hospital", "1000"));
                list.add(new Doctor("Dr. Vivek Anand", category, "Fortis Heart Center", "1200"));
                list.add(new Doctor("Dr. Karan Malhotra", category, "Max Heart Institute", "1100"));
                list.add(new Doctor("Dr. Ankit Sharma", category, "Medanta Heart Care", "1300"));
                list.add(new Doctor("Dr. Rohit Gupta", category, "Global Heart Clinic", "1150"));
                list.add(new Doctor("Dr. Nikhil Verma", category, "Care Cardiac Center", "1250"));
                list.add(new Doctor("Dr. Sandeep Mehra", category, "Metro Heart Hospital", "1180"));
                list.add(new Doctor("Dr. Ashish Jain", category, "Pulse Heart Clinic", "1050"));
                list.add(new Doctor("Dr. Piyush Arora", category, "Healthy Heart Center", "1350"));
                list.add(new Doctor("Dr. Tarun Khanna", category, "Advanced Cardio Care", "1400"));
                break;

            default:
                list.add(new Doctor("Dr. General One", category, "General Hospital", "300"));
                list.add(new Doctor("Dr. General Two", category, "City Hospital", "350"));
                break;
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new DoctorAdapter(this, list));
    }
}