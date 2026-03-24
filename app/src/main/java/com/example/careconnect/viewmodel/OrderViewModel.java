package com.example.careconnect.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.*;

import com.example.careconnect.database.AppDatabase;
import com.example.careconnect.model.Order;

import java.util.List;
import java.util.concurrent.Executors;

public class OrderViewModel extends AndroidViewModel {

    private final AppDatabase db;

    public OrderViewModel(@NonNull Application app) {
        super(app);
        db = AppDatabase.getInstance(app);
    }

    public void insert(Order o) {
        Executors.newSingleThreadExecutor().execute(() -> db.orderDao().insert(o));
    }

    public LiveData<List<Order>> getAll() {
        return db.orderDao().getAll();
    }
}