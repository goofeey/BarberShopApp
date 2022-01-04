package com.example.barbershopapp.database;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbershopapp.R;

public class AppointmentViewHolder extends RecyclerView.ViewHolder {

    private final TextView textViewName, textViewNumber, textViewDate, textViewTime;


    public AppointmentViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName=itemView.findViewById(R.id.tvName);
        textViewNumber=itemView.findViewById(R.id.tvNumber);
        textViewDate=itemView.findViewById(R.id.tvDate);
        textViewTime=itemView.findViewById(R.id.tvTime);
    }

    public TextView getTextViewName() {
        return textViewName;
    }
    public TextView getTextViewNumber() {
        return textViewNumber;
    }
    public TextView getTextViewDate() {
        return textViewDate;
    }
    public TextView getTextViewTime() {
        return textViewTime;
    }
}
