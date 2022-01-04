package com.example.barbershopapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppointmentDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Appointment appointment);

    @Query("DELETE FROM appointment_table")
    void deleteAll();

    @Query("SELECT * from appointment_table ORDER BY name ASC")
    LiveData<List<Appointment>> getAlphabetizedWords();
}