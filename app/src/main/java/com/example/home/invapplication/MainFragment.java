package com.example.home.invapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {




    public MainFragment() {
        // Required empty public constructor


    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ImageView borrow = (ImageView)v.findViewById(R.id.borrow);
        borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainBorrow.class);
                startActivity(intent);
            }
        });// การยืม

        ImageView imgReturnBorrow = (ImageView)v.findViewById(R.id.imgReturnBorrow);
        imgReturnBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainBorrowReturn.class);
                startActivity(intent);
            }
        });



        ImageView imgBorrowList = (ImageView)v.findViewById(R.id.imgBorrowList);
        imgBorrowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BorrowList.class);
                startActivity(intent);
            }
        });

        ImageView imgborrowBroken = (ImageView)v.findViewById(R.id.imgborrowBroken);
        imgborrowBroken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Mainborrowbroken.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutplace = (LinearLayout)v.findViewById(R.id.layoutplace);
        layoutplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }




}
