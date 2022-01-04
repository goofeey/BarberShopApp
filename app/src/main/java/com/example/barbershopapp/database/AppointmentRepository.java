package com.example.barbershopapp.database;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

public class AppointmentRepository {

    private AppointmentDAO appointmentDAO;
    private LiveData<List<Appointment>> allAppointments;

    AppointmentRepository(Application application) {
        AppointmentRoomDatabase db = AppointmentRoomDatabase.getDatabase(application);
        appointmentDAO = db.appointmentDAO();
        allAppointments = appointmentDAO.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Appointment>> getAllAppointments() {
        return allAppointments;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Appointment appointment) {
        AppointmentRoomDatabase.databaseWriteExecutor.execute(() -> {
            appointmentDAO.insert(appointment);
        });
    }
}