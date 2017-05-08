package com.example.home.invapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainBorrowReturn extends AppCompatActivity {
    private OPPMSService service;
    private MainBorrowReturn activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_borrow);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);
        MainBorrowReturn();



    }
    public void MainBorrowReturn(){
            service.getData().enqueue(new Callback<OPPMSDAO>() {
                @Override
                public void onResponse(Call<OPPMSDAO> call, Response<OPPMSDAO> response) {
                    for(int i=0;i<response.body().details.size();i++){
                        Log.d("data",response.body().details.get(i).borrow_id);}
                }

                @Override
                public void onFailure(Call<OPPMSDAO> call, Throwable t) {

                }
            });
    }
}
