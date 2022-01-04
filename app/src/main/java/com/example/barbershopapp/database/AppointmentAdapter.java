package com.example.barbershopapp.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbershopapp.R;

import java.util.List;
import java.util.zip.Inflater;

public class AppointmentAdapter extends RecyclerView.Adapter<com.example.barbershopapp.database.AppointmentViewHolder>  {

    private List<Appointment> appointments;
    private final LayoutInflater inflater;


    public AppointmentAdapter(Context context) {
        this.inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_appointment, parent, false);
        return new AppointmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        Appointment appointment=appointments.get(position);
        holder.getTextViewName().setText(appointment.getName());
        holder.getTextViewNumber().setText(String.valueOf(appointment.getNumber()));
        holder.getTextViewDate().setText(String.valueOf(appointment.getDate()));
        holder.getTextViewTime().setText(String.valueOf(appointment.getTime()));


    }
    public void setAppointments(List<Appointment> appointmentList){
        appointments = appointmentList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (appointments!= null)
            return appointments.size();
        else return 0;

    }
}
