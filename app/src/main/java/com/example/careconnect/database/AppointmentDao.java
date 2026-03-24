package com.example.careconnect.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.careconnect.model.Appointment;

import java.util.List;

@Dao
public interface AppointmentDao {

    @Insert
    void insert(Appointment appointment);

    @Query("SELECT * FROM appointments")
    LiveData<List<Appointment>> getAll();

    // 🔥 DELETE
    @Delete
    void delete(Appointment appointment);
}
