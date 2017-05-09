package com.example.home.invapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
                String borrow_sdate = dates.getText().toString();
                String borrow_edate = datee.getText().toString();
                String borrow_cos_id = add_borrow.getText().toString();
                String borrow_product_id = add_order.getText().toString();

                service.getOPPMSBorrow(borrow_sdate,borrow_edate,borrow_cos_id,borrow_product_id).enqueue(new Callback<SendQuick>()
                {
                    @Override
                    public void onResponse(Call<SendQuick> call, Response<SendQuick> response) {
                        Log.d("RESPONSE :: ", response.body().result);
                        CharSequence text = response.body().result;
                        final int chk = Integer.parseInt(text.toString());

                    }

                    @Override
                    public void onFailure(Call<SendQuick> call, Throwable t) {

                    }
                });



            }
        });
    }

}

