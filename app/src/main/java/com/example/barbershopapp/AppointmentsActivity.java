package com.example.barbershopapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.barbershopapp.database.Appointment;
import com.example.barbershopapp.database.AppointmentViewModel;
import com.example.barbershopapp.databinding.ActivityAppointmentsBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class AppointmentsActivity extends AppCompatActivity{

    private AppointmentsViewModel appointmentsViewModel;
    private ActivityAppointmentsBinding binding;

    private EditText etDate, etTime;
    private TextInputEditText etName, etNumber;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Button btn;
    private Appointment appointment;
    private AppointmentViewModel appointmentViewModel;
    private TimePickerDialog.OnTimeSetListener timeSetListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppointmentsBinding.inflate(getLayoutInflater());
        //View root = binding.getRoot();
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        appointmentViewModel = new ViewModelProvider(this).get(AppointmentViewModel.class);




        etDate = binding.textInputEditTextDate;
        etTime = binding.textInputEditTextTime;

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(AppointmentsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String data = day + "/" + month + "/" + year;
                        etDate.setText(data);
                    }
                }, year, month, day);
                dialog.show();

            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog dialog = new TimePickerDialog(AppointmentsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        String time = hour + " : " + minute;
                        etTime.setText(time);
                    }
                }, hour, minute, false);
                dialog.show();
            }
        });

        btn = binding.buttonAdd;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName = binding.textInputEditTextName;
                etNumber = binding.textInputEditTextNumber;
                etDate = binding.textInputEditTextDate;
                etTime = binding.textInputEditTextTime;


                String name = etName.getText().toString();
                int number = Integer.parseInt(etNumber.getText().toString());
                String date = etDate.getText().toString();
                String time = etTime.getText().toString();


                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(etName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    appointment = new Appointment(name, number, date, time);
                    appointmentViewModel.insert(appointment);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
        //return root;

    }


}

