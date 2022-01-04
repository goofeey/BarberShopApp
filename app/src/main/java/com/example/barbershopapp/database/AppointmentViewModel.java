package com.example.barbershopapp.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AppointmentViewModel extends AndroidViewModel {

    private AppointmentRepository repository;

    private LiveData<List<Appointment>> allAppointments;

    public AppointmentViewModel(Application application) {
        super(application);
        repository = new AppointmentRepository(application);
        allAppointments = repository.getAllAppointments();
    }

    public LiveData<List<Appointment>> getAllAppointments() {
        return allAppointments;
    }

    public void insert(Appointment appointment) {
        repository.insert(appointment);
    }
}
