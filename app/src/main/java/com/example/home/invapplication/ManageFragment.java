package com.example.home.invapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManageFragment extends Fragment {


    public ManageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_manage, container, false);
        Button btnProfile = (Button) v.findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                //Set the fragment ให้เชื่อมกับ MainFragment และแสดงหน้า fragment_main.xml
                ProfileFragment fragment = new ProfileFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        Button btnChange = (Button) v.findViewById(R.id.btnChangepass);
        btnChange.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                //Set the fragment ให้เชื่อมกับ ChangPasseordFragment และแสดงหน้า fragment_chang_password.xml
                ChangPasswordFragment fragment = new ChangPasswordFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            };;;;
        });

        return v;

    }

}
