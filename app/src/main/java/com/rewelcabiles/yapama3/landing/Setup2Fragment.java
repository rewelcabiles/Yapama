package com.rewelcabiles.yapama3.landing;

import android.os.Bundle;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rewelcabiles.yapama3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Setup2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Setup2Fragment extends Fragment {

    private AppCompatButton button_pgp;
    private AppCompatButton button_pbe;
    private AppCompatButton button_back;

    public Setup2Fragment() {
        // Required empty public constructor
    }


    public static Setup2Fragment newInstance() {
        Setup2Fragment fragment = new Setup2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setup2, container, false);
        button_pgp = (AppCompatButton) view.findViewById(R.id.encrypt_1);
        button_pbe = (AppCompatButton) view.findViewById(R.id.encrypt_2);
        button_back = (AppCompatButton) view.findViewById(R.id.back);

        button_pgp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((MainActivity) getActivity()).setEncrypt("pgp");
            }
        });
        button_pbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((MainActivity) getActivity()).setEncrypt("pbe");
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((MainActivity) getActivity()).openFragment("storage");
            }
        });
        return view;
    }
}