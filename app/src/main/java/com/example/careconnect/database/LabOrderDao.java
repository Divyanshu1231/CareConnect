package com.example.careconnect.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.careconnect.model.LabOrder;

import java.util.List;

@Dao
public interface LabOrderDao {

    @Insert
    void insert(LabOrder order);

    @Query("SELECT * FROM lab_orders ORDER BY id DESC")
    LiveData<List<LabOrder>> getAll();
}