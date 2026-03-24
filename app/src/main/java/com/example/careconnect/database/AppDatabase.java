package com.example.careconnect.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.careconnect.model.Appointment;
import com.example.careconnect.model.LabOrder;
import com.example.careconnect.model.Order;   // 🔥 ADD
import com.example.careconnect.model.User;

@Database(
        entities = {
                User.class,
                Appointment.class,
                Order.class,   // 🔥 VERY IMPORTANT
                LabOrder.class
        },
        version = 3   // 🔥 version increase
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract AppointmentDao appointmentDao();
    public abstract OrderDao orderDao();
    public abstract LabOrderDao labOrderDao(); // 🔥 ADD// ✅ already present

    public static synchronized AppDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "health_db"
                    )
                    .fallbackToDestructiveMigration() // 🔥 safe for dev
                    .build();
        }

        return instance;
    }
}