package com.logesh.loadrunnerpoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

public class FragmentProfile extends Fragment {

    View view;
    Button tab_view,edit_detils;
    RelativeLayout changePasswordRelativeLayout, logOutRelativeLayout,createProfileRelativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);


        init(view);



        return view;
    }

    void init(View view) {

        changePasswordRelativeLayout = view.findViewById(R.id.changePasswordRelativeLayout);
        edit_detils = view.findViewById(R.id.edit_detils);
        tab_view = view.findViewById(R.id.tab_view);
        logOutRelativeLayout = view.findViewById(R.id.logOutRelativeLayout);
        createProfileRelativeLayout = view.findViewById(R.id.createProfileRelativeLayout);

        logOutRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        createProfileRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CreateProfileActivity.class);
                startActivity(intent);
            }
        });

        changePasswordRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        edit_detils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        tab_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TapViewProfileActivity.class);
                startActivity(intent);
            }
        });




    }
}

