package com.example.home.invapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChangPasswordFragment extends Fragment {


    public ChangPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chang_password, container, false);
        Button btnCancle = (Button) v.findViewById(R.id.btnCancle);
        btnCancle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Set the fragment ให้เชื่อมกับ MainFragment และแสดงหน้า fragment_main.xml
                ManageFragment fragment = new ManageFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }



}