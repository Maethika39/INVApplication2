package com.example.home.invapplication;

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

    @FormUrlEncoded
    @POST("application/views/inventory/borrow/Andriod_SMEs/SMEs_insert_borrow.php") // ส่งข้อมูล
    Call<SendQuick> getOPPMSBorrow(@Field("borrow_sdate") String borrow_sdate,
                                 @Field("borrow_edate") String borrow_edate,
                                 @Field("borrow_cos_id") String borrow_cos_id,
                                 @Field("borrow_product_id") String borrow_product_id);




    @POST("application/views/inventory/borrow/Andriod_SMEs/SMES_select_borrow.php")
    Call<OPPMSDAO> getฺBorrow(); // รับข้อมูลการยืม


}
