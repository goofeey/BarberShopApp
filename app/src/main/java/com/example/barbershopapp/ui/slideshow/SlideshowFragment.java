package com.example.barbershopapp.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.barbershopapp.R;
import com.example.barbershopapp.databinding.FragmentSlideshowBinding;


public class SlideshowFragment extends Fragment {

    private SlideshowViewModel contactsViewModel;
    private FragmentSlideshowBinding binding;
    private TextView etAdresa;

    @Override
    public void onResume() {
        super.onResume();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Contact");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactsViewModel =
                new ViewModelProvider(this).get(com.example.barbershopapp.ui.slideshow.SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        etAdresa = root.findViewById(R.id.textViewAdresa);

        etAdresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openWebPage = new Intent(Intent.ACTION_VIEW);
                openWebPage.setData(Uri.parse("https://www.google.com/maps/place/Piața+Arcul+de+Triumf,+București/@44.466807,26.0780519,18z/data=!4m5!3m4!1s0x40b2021726538021:0x97f8bd6e933d23d!8m2!3d44.4671996!4d26.0781827"));
                startActivity(openWebPage);
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