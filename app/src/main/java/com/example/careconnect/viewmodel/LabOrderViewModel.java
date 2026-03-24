package com.example.careconnect.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.*;

import com.example.careconnect.database.AppDatabase;
import com.example.careconnect.model.LabOrder;

import java.util.List;
import java.util.concurrent.Executors;

public class LabOrderViewModel extends AndroidViewModel {

    private final AppDatabase db;

    public LabOrderViewModel(@NonNull Application app) {
        super(app);
        db = AppDatabase.getInstance(app);
    }

    public void insert(LabOrder o) {
        Executors.newSingleThreadExecutor().execute(() ->
                db.labOrderDao().insert(o)
        );
    }

    public LiveData<List<LabOrder>> getAll() {
        return db.labOrderDao().getAll();
    }
}