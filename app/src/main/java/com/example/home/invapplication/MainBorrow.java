package com.example.home.invapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainBorrow extends AppCompatActivity {

    private OPPMSService service;
    private MainBorrow activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_borrow);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);


        MainBorrow();


    }

    public void MainBorrow() {
        final EditText dates = (EditText) findViewById(R.id.dates);
        final EditText datee = (EditText) findViewById(R.id.datee);
        final EditText add_borrow = (EditText) findViewById(R.id.add_borrow);
        final EditText add_order = (EditText) findViewById(R.id.add_order);
        final Button button_submit = (Button) findViewById(R.id.button_submit);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date1 = dates.getText().toString();
                String date2 = datee.getText().toString();
                String add_borrow1 = add_borrow.getText().toString();
                String add_order1 = add_order.getText().toString();
            }
        });
    }

}

