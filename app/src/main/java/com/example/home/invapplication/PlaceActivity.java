package com.example.home.invapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class PlaceActivity extends Activity  {
    String[] mobileArray = {"นายขยัน ขันแข็ง","นางสมจิต มั่งคง","นายสมชาย มั่งคั่ง","นางสาวกานดา มั่งมี",
            "นางสาวธิราวรร ตังไม่มี","นายศรันย์ สวยจังเลย","นางพอลลี่ คนขายน้ำแข็ง","นายโชคดี มีตังค์","นายดวงดี ร้านขนม",
            "นางสาวรัตนา มีความสุข","นายน๊อต คนเล่นหุ้น","นายสมจิต ค่ายมวย","นายอารมณ์ดี นะจ๊ะ","นายช๊อปเปอร์ อู่ซ่อมรถ",
            "นางสาวฟ้า ร้านหมูกระทะ","นายเก็ตตี้ ร้านชาบู","นางไก่ ร้านผัดไท"};

    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.place_listview, mobileArray);*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                mobileArray
        );
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity = new Intent(view.getContext(), MapsActivity.class );
                switch( position )
                {
                    case 0:
                        startActivity(newActivity);
                        break;
                    case 1:  //Intent newActivity2 = new Intent(view.getContext(), BorrowList.class);
                        startActivity(newActivity);
                        break;
                    case 2:  //Intent newActivity = new Intent(view.getContext(), ProfileFragment.class);
                        startActivity(newActivity);
                        break;
                    case 3:  //Intent newActivity = new Intent(view.getContext(), ProfileFragment.class);
                        startActivity(newActivity);
                        break;
                    case 4:  //Intent newActivity = new Intent(view.getContext(), ProfileFragment.class);
                        startActivity(newActivity);
                        break;
                    case 5:  //Intent newActivity = new Intent(view.getContext(), ProfileFragment.class);
                        startActivity(newActivity);
                        break;
                    case 6:  //Intent newActivity = new Intent(view.getContext(), ProfileFragment.class);
                        startActivity(newActivity);
                        break;
                    case 7:  //Intent newActivity = new Intent(view.getContext(), ProfileFragment.class);
                        startActivity(newActivity);
                        break;
                    case 8:  //Intent newActivity = new Intent(view.getContext(), ProfileFragment.class);
                        startActivity(newActivity);
                        break;
                }
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Toast.makeText(getApplicationContext(),String.valueOf(adapter.getItemId(position)),
//                //Toast.LENGTH_SHORT).show();
//                Intent editIntent = new Intent(getApplicationContext(), MainLogin.class);
//                startActivity(editIntent);
//            }
//        });
//
//        ImageView imgReturnBorrow = (ImageView)v.findViewById(R.id.imgReturnBorrow);
//        imgReturnBorrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MainBorrowReturn.class);
//                startActivity(intent);
//            }
//        });
    }
}
