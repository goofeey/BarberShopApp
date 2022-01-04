package com.example.barbershopapp.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "appointment_table")

public class Appointment {


        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "name")
        private String name;

        @ColumnInfo(name = "number")
        private int number;

        @ColumnInfo(name = "date")
        private String date;

        @ColumnInfo(name = "time")
        private String time;

        public Appointment(@NonNull String name, int number, String date, String time) {
            this.name=name;
            this.date=date;
            this.number=number;
            this.time=time;
        }




    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void insert(Appointment appointment) {
    }
}

