package com.example.home.invapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phrompongkhagtes on 5/9/2017 AD.
 */

public class EditPerson {

    @SerializedName("name")
    public String name;

    @SerializedName("address")
    public String address;

    @SerializedName("house_number")
    public String house_number;

    @SerializedName("telephone")
    public String telephone;

    @SerializedName("email")
    public String email;

}
