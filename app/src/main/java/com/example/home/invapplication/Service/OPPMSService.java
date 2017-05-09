package com.example.home.invapplication.Service;

import com.example.home.invapplication.OPPMSDAO;
import com.example.home.invapplication.SendQuick;
import com.example.home.invapplication.Service.OPPMSDAOBYPERSON;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by phrompongkhagtes on 5/8/2017 AD.
 */

public interface OPPMSService {

    @FormUrlEncoded
    @POST("application/views/inventory/borrow/Andriod_SMEs/SMEs_chkLogin.php") // ส่งข้อมูล
    Call<SendQuick> getOPPMSData(@Field("email") String email,
                                 @Field("password") String password);

    @POST("application/views/inventory/borrow/Andriod_SMEs/SMES_select_borrow_return.php")
    Call<OPPMSDAO> getData(); //รับข้อมูล

    //SMEs_EditPerson.php

    @POST("application/views/inventory/borrow/Andriod_SMEs/SMEs_EditPerson.php")
    Call<OPPMSDAOBYPERSON> GetDataPerson(); //รับข้อมูล

    @FormUrlEncoded
    @POST("application/views/inventory/borrow/Andriod_SMEs/SMEs_insert.php") // ส่งข้อมูล
    Call<SendQuick> sendData(@Field("name") String name,
                             @Field("address") String address,
                             @Field("house_number") String house_number,
                             @Field("telephone") String telephone,
                             @Field("email") String email,
                             @Field("position") String position,
                             @Field("password") String password,
                             @Field("password_again") String password_again);
}
