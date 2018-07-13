package com.example.android.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView)findViewById(R.id.list_item);
        arrayList = new ArrayList<>();

        Intent i =getIntent();
        String input = i.getStringExtra("input");
        String input1 = i.getStringExtra("input1");
        String input2 = i.getStringExtra("input2");
        String input3 = i.getStringExtra( "input3");
        String input4 = i.getStringExtra("input4");
        String date = i.getStringExtra("datetime");
        String txttime = i.getStringExtra("txttime");
       // listView.setText("Name : " + input + "\nEmail:" + input1 + "\nPhoneNumber : " + input2 + "\nAge: " + input3 + "\nGender: "+input4 +"\nDOB: " + date +"Registration: " +txttime);
        arrayList.add(input);
        arrayList.add(input1);
        arrayList.add(input2);
        arrayList.add(input3);
        arrayList.add(input4);
        arrayList.add(date);
        arrayList.add(txttime);

        arrayAdapter =  new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);


    }

}
