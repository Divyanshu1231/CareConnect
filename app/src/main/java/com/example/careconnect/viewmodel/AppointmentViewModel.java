package com.example.careconnect.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.careconnect.model.Appointment;
import com.example.careconnect.repository.AppointmentRepository;

import java.util.List;

public class AppointmentViewModel extends AndroidViewModel {

    private AppointmentRepository repo;

    public AppointmentViewModel(@NonNull Application app) {
        super(app);
        repo = new AppointmentRepository(app);
    }

    public void insert(Appointment a) {
        repo.insert(a);
    }

    public LiveData<List<Appointment>> getAll() {
        return repo.getAll();
    }

    //Delete
    public void delete(Appointment a) {
        repo.delete(a);
    }
}