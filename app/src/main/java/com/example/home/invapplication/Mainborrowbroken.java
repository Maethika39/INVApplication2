package com.example.home.invapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.home.invapplication.Service.OPPMSService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mainborrowbroken extends AppCompatActivity {
    private OPPMSService service;
    private Mainborrowbroken activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrowbroken);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);
        activity = this;
        BorrowBroken();
    }

    public void BorrowBroken(){
        service.getData().enqueue(new Callback<OPPMSDAO>() {
            @Override
            public void onResponse(Call<OPPMSDAO> call, Response<OPPMSDAO> response) {
                for(int i=0;i<response.body().details.size();i++){
                      // Log.d("Borrow id : ",response.body().details.get(i).borrow_id);
//                        Log.d("Borrow id : ",response.body().details.get(i).borrow_code);
//                        Log.d("Borrow id : ",response.body().details.get(i).imem_first_name);
                    //Log.d("Borrow id : ",response.body().details.get(i).prob_name);

//                    MyAdapterBorrowReturn adapter = new MyAdapterBorrowReturn(activity,response.body().details);
//                    ListView listView = (ListView)findViewById(R.id.tvlistview1);
//                    listView.setAdapter(adapter);

                    MyAdapterBorrowBroken adapter = new MyAdapterBorrowBroken(activity,response.body().details);
                    ListView ListView = (android.widget.ListView)findViewById(R.id.tvlistviewBroken);
                    ListView.setAdapter(adapter);



                }
            }

            @Override
            public void onFailure(Call<OPPMSDAO> call, Throwable t) {

            }
        });
    }
}
