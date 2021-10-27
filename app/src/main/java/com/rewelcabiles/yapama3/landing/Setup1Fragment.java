package com.rewelcabiles.yapama3.landing;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rewelcabiles.yapama3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Setup1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Setup1Fragment extends Fragment {

    private AppCompatButton button_drive;
    private AppCompatButton button_ftp;
    private AppCompatButton button_git;

    public Setup1Fragment() {
        // Required empty public constructor
    }

    public static Setup1Fragment newInstance() {
        Setup1Fragment fragment = new Setup1Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setup1, container, false);

        button_drive = (AppCompatButton) view.findViewById(R.id.platform_1);
        button_git = (AppCompatButton) view.findViewById(R.id.platform_2);
        button_ftp = (AppCompatButton) view.findViewById(R.id.platform_3);

        button_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((MainActivity) getActivity()).setStorage("drive");
            }
        });
        button_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((MainActivity) getActivity()).setStorage("git");
            }
        });
        button_ftp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((MainActivity) getActivity()).setStorage("ftp");
            }
        });

        return view;
    }
}