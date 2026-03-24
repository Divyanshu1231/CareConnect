package com.example.careconnect.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "orders")
public class Order {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String date;
    public String status;
    public int amount;
}