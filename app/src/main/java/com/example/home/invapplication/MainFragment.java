package com.example.home.invapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {




    public MainFragment() {
        // Required empty public constructor


    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView borrow = (ImageView)v.findViewById(R.id.borrow);
        borrow.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                ProfileFragment fragment = new ProfileFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_borrow, fragment);
                fragmentTransaction.commit();
            }


        });


       // View v = inflater.inflate(R.layout.fragment_main, container, false);

        return v;
    }






}
