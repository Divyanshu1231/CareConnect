package com.example.careconnect.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lab_orders")
public class LabOrder {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String testName;
    public String date;
    public String status;
    public int amount;
}