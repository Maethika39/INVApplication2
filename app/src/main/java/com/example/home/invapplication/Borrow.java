package com.example.home.invapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Natchapon on 9/5/2560.
 */

public class Borrow {

    @SerializedName("borrow_id")
    public String borrow_id;

    @SerializedName("borrow_sdate")
    public String borrow_sdate;

    @SerializedName("borrow_edate")
    public String borrow_edate;

    @SerializedName("imem_first_name")
    public String imem_first_name;

    @SerializedName("imem_last_name")
    public String imem_last_name;

    @SerializedName("prob_name")
    public String prob_name;
}
