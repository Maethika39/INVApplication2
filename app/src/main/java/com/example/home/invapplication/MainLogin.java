package com.example.home.invapplication;

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

public class MainLogin extends AppCompatActivity {
    private OPPMSService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);
        ChangePage();
        Login();















    }

    public void Login(){
        final EditText etemail = (EditText)findViewById(R.id.etUsername);
        final EditText etpasswords = (EditText)findViewById(R.id.etPassword);
        final Button btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etemail.getText().toString();
                final String password = etpasswords.getText().toString();


                service.getOPPMSData(email,password).enqueue(new Callback<SendQuick>() {
                    @Override
                    public void onResponse(Call<SendQuick> call, Response<SendQuick> response)
                    {
                        Log.d("RESPONSE :: ",response.body().result);
                        CharSequence text = response.body().result;
                        final int  chk = Integer.parseInt(text.toString());

                        if(chk==1){
                            Toast toast = Toast.makeText(getApplicationContext(),"LOGIN SUCCESS",Toast.LENGTH_SHORT);
                            toast.show();

                            Intent intent = new Intent(MainLogin.this,MainActivity.class);
                            intent.putExtra("name", email);
                            intent.putExtra("password", password);

                            MainLogin.this.startActivity(intent);






                        }
                        else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainLogin.this);
                            builder.setMessage("LOGIN FAIL")
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
    public void ChangePage(){
          /* เปลี่ยนหน้าไปเป็น หน้าสมัครสมาชิก*/
        Button btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
