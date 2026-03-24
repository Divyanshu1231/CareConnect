package com.example.careconnect.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.careconnect.model.Order;

import java.util.List;

@Dao
public interface OrderDao {

    @Insert
    void insert(Order order);

    @Query("SELECT * FROM orders ORDER BY id DESC")
    LiveData<List<Order>> getAll();
}