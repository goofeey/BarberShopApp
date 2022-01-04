package com.example.barbershopapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Appointment.class}, version = 1, exportSchema = false)
public abstract class AppointmentRoomDatabase extends RoomDatabase {

    abstract AppointmentDAO appointmentDAO();

    private static volatile AppointmentRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppointmentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppointmentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppointmentRoomDatabase.class, "appointment_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}