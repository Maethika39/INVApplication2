package com.example.home.invapplication;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.invapplication.Service.OPPMSDAOBYPERSON;
import com.example.home.invapplication.Service.OPPMSService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private OPPMSService service;
    private MainBorrowReturn activity;
    String email;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Button btnCancle = (Button) v.findViewById(R.id.cancel);
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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);






        service.GetDataPerson().enqueue(new Callback<OPPMSDAOBYPERSON>() {
            @Override
            public void onResponse(Call<OPPMSDAOBYPERSON> call, Response<OPPMSDAOBYPERSON> response) {
                for(int i=0;i<response.body().Person.size();i++){

                    EditText fullnametext = (EditText)v.findViewById(R.id.fullNameText);
                    fullnametext.setText(response.body().Person.get(i).name);

                    EditText addressText = (EditText)v.findViewById(R.id.addressText);
                    addressText.setText(response.body().Person.get(i).address);

                    EditText tellPhone = (EditText)v.findViewById(R.id.tellText);
                    tellPhone.setText(response.body().Person.get(i).house_number);

                    EditText tellPhoneText = (EditText)v.findViewById(R.id.tellPhoneText);
                    tellPhoneText.setText(response.body().Person.get(i).telephone);

                    EditText email = (EditText)v.findViewById(R.id.emailText);
                    email.setText(response.body().Person.get(i).email);

                    EditText rankText = (EditText)v.findViewById(R.id.rankText);
                    rankText.setText(response.body().Person.get(i).position);






                }
            }

            @Override
            public void onFailure(Call<OPPMSDAOBYPERSON> call, Throwable t) {

            }
        });





        // Inflate the layout for this fragment
        return v;


    }

}
