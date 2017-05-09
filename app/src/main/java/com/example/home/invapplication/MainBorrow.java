package com.example.home.invapplication;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.invapplication.Service.OPPMSService;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainBorrow extends AppCompatActivity {
    Button button1,button22;
    private Spinner mEnglishSpinner;
    private Spinner mThaiSpinner;
    private ArrayList<String> mThaiClub = new ArrayList<String>();
    private ImageView Borrow;
    private OPPMSService service;
    Button btn_submit;
    Button btn_cancle;

    private MainBorrow activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_borrow);


       Button btnSubmitBorrow = (Button)findViewById(R.id.btnSubmitBorrow);
        btnSubmitBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(), "SAVE SUCCESS",
                       Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainBorrow.this,MainActivity.class);

                MainBorrow.this.startActivity(intent);
//                TextView Sdate = (TextView)findViewById(R.id.textView1);
//                TextView Edate = (TextView)findViewById(R.id.textView22);
//                Spinner NamePeron = (Spinner)findViewById(R.id.english_club);
//
//
//
//                String SDate = Sdate.getText().toString();
//                String EDate = Edate.getText().toString();



//                Toast.makeText(getApplicationContext(), sdate,
//                        Toast.LENGTH_LONG).show();
            }
        });


















        button1 = (Button)findViewById(R.id.button1);
        button22 = (Button)findViewById(R.id.button22);
        btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_cancle = (Button)findViewById(R.id.btn_cancle);







        button1.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DialogFragment dialogfragment = new DatePickerDialogTheme1();

                dialogfragment.show(getFragmentManager(), "Theme 1");

            }

        });
        button22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DialogFragment dialogfragment = new DatePickerDialogTheme1.DatePickerDialogTheme22();

                dialogfragment.show(getFragmentManager(), "Theme 22");


            }

        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });


        mEnglishSpinner = (Spinner) findViewById(R.id.english_club);
        mThaiSpinner = (Spinner) findViewById(R.id.thai_club);

        createThaiClubData();

// Adapter ตัวแรก
        ArrayAdapter<String> adapterThai = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, mThaiClub);
        mThaiSpinner.setAdapter(adapterThai);


        String[] englishClub = getResources().getStringArray(R.array.club);
        ArrayAdapter<String> adapterEnglish = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, englishClub);
        mEnglishSpinner.setAdapter(adapterEnglish);


    } // End OnCreate
    public static class DatePickerDialogTheme1 extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                    AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,year,month,day);

            return datepickerdialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day){

            TextView textview = (TextView)getActivity().findViewById(R.id.textView1);

            textview.setText(day + ":" + (month+1) + ":" + year);

        }

        public static class DatePickerDialogTheme22 extends DialogFragment implements DatePickerDialog.OnDateSetListener{

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState){
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                        AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,year,month,day);

                return datepickerdialog;
            }

            public void onDateSet(DatePicker view, int year, int month, int day){

                TextView textview = (TextView)getActivity().findViewById(R.id.textView22);

                textview.setText(day + ":" + (month+1) + ":" + year);

            }
        }
    }
    private void createThaiClubData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);
        activity = this;

        service.getProduct().enqueue(new Callback<OPPMSDAO>() {
            @Override
            public void onResponse(Call<OPPMSDAO> call, Response<OPPMSDAO> response) {
                for(int i=0;i<response.body().details.size();i++) {
                   // Log.d("Borrow id : ",response.body().details.get(i).iprd_name);


                    mThaiClub.add(response.body().details.get(i).iprd_name);


                }

            }

            @Override
            public void onFailure(Call<OPPMSDAO> call, Throwable t) {

            }
        });





        mThaiClub.add("ถังน้ำแข็ง");


    }

}
