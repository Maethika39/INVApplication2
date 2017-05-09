package com.example.home.invapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phrompongkhagtes on 5/10/2017 AD.
 */

public class MyAdapterBorrowBroken extends BaseAdapter {

    private final ArrayList<BorrowReturn> details;
    private final LayoutInflater inflater;

    MyAdapterBorrowBroken(Mainborrowbroken activity,ArrayList<BorrowReturn>details){
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.details = details;
    }

    public int getCount() {
        return details.size();
    }

    public Object getItem(int position) {
        return details.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(R.layout.activity_click_broken, null);


        TextView textview = (TextView) view.findViewById(R.id.textView1);
        textview.setText(details.get(position).borrow_code);


        return view;

    }
}
