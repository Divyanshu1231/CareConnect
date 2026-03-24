package com.example.careconnect.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "appointments")
public class Appointment {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String doctorName;
    public String date;
    public String time;
    public String status;
}