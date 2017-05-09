package com.example.home.invapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by phrompongkhagtes on 5/9/2017 AD.
 */

public class OPPMSDAO {

    @SerializedName("details")
    public ArrayList<BorrowReturn> details;

    @SerializedName("details")
    public ArrayList<Borrow> detailborrow;
}
