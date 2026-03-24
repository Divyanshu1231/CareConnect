package com.example.careconnect.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bookmark {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String desc;
}