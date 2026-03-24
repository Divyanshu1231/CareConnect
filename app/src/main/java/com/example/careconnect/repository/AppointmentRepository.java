package com.example.careconnect.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.careconnect.database.AppDatabase;
import com.example.careconnect.database.AppointmentDao;
import com.example.careconnect.model.Appointment;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppointmentRepository {

    private AppointmentDao dao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public AppointmentRepository(Application app) {
        dao = AppDatabase.getInstance(app).appointmentDao();
    }

    public void insert(Appointment a) {
        executor.execute(() -> dao.insert(a));
    }

    public LiveData<List<Appointment>> getAll() {
        return dao.getAll();
    }

    public void delete(Appointment a) {
        executor.execute(() -> dao.delete(a));
    }
}