package com.example.barbershopapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbershopapp.R;
import com.example.barbershopapp.database.Appointment;
import com.example.barbershopapp.database.AppointmentAdapter;
import com.example.barbershopapp.database.AppointmentViewModel;
import com.example.barbershopapp.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private RecyclerView recyclerView;
    private AppointmentViewModel appointmentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recyclerview);
        final AppointmentAdapter adapter = new AppointmentAdapter(root.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        appointmentViewModel = new ViewModelProvider(getActivity()).get(AppointmentViewModel.class);
        appointmentViewModel.getAllAppointments().observe(getActivity(), new Observer<List<Appointment>>() {
            @Override
            public void onChanged(@Nullable final List<Appointment> appointments) {
                adapter.setAppointments(appointments);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}