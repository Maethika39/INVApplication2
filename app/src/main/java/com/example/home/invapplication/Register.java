package com.example.home.invapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.invapplication.Service.OPPMSService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {
    private OPPMSService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);

        Register();




    }


    public void Register(){
        final EditText editTextName = (EditText)findViewById(R.id.editTextName);
        final EditText editTextAddress = (EditText)findViewById(R.id.editTextAddress);
        final EditText editTextTell = (EditText)findViewById(R.id.editTextTell);
        final EditText editTextTellPhone = (EditText)findViewById(R.id.editTextTellPhone);
        final EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        final EditText editTextPosition = (EditText)findViewById(R.id.editTextPosition);
        final EditText editTextPass = (EditText)findViewById(R.id.editTextPass);
        final EditText editTextPass2 = (EditText)findViewById(R.id.editTextPass);

        Button buttonSubmit = (Button)findViewById(R.id.buttonSubmit);



        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String house_number = editTextTell.getText().toString();
                String telephone = editTextTellPhone.getText().toString();
                String email = editTextEmail.getText().toString();
                String position = editTextPosition.getText().toString();
                String password = editTextPass.getText().toString();
                String password_again = editTextPass2.getText().toString();

                service.sendData(name,address,house_number,telephone,email,position,password,password_again).enqueue(new Callback<SendQuick>() {
                    @Override
                    public void onResponse(Call<SendQuick> call, Response<SendQuick> response) {
                        Log.d("RESPONSE : ",response.body().result);
                        CharSequence text_result = response.body().result;
                        final int  chk = Integer.parseInt(text_result.toString());

                        if(chk==1){
                            Context context = getApplicationContext();
                            CharSequence text = "SAVE SUCCESS";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            Intent intent = new Intent(Register.this,MainLogin.class);
                            Register.this.startActivity(intent);
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                            builder.setMessage("\n" +
                                    "Please fill in all information.")
                                    .setNegativeButton("Retry",null)
                                    .create()
                                    .show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SendQuick> call, Throwable t) {

                    }
                });

            }
        });



    }


}
