package com.example.android.login;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText phonenumber;
    EditText age;
    Button btn;
    RadioGroup radiogrp;
    Button btn1;
    String input4;
    CheckBox checkbox;
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    int mYear, mMonth, mDay, mHour, mMinute;
    DatePickerDialog datePickerDialog;
    //  RadioButton radioButton;


    //@SuppressLint("WrongViewCast")//
    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phonenumber = (EditText) findViewById(R.id.textView2);
        age = (EditText) findViewById(R.id.textView3);
        radiogrp = (RadioGroup) findViewById(R.id.Gender);
        btn1 = (Button) findViewById(R.id.button2);
        checkbox = (CheckBox) findViewById(R.id.checkBox);
        btn = (Button) findViewById(R.id.button);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = name.getText().toString();
                String input1 = email.getText().toString();
                String input2 = phonenumber.getText().toString();
                String input3 = age.getText().toString();
                int id = radiogrp.getCheckedRadioButtonId();
                String txttime = txtTime.getText().toString();
                String date = txtDate.getText().toString();


                ///RadioButton radioButton = (RadioButton) findViewById(id);
                // = radioButton.getText().toString();
                switch (id) {
                    case R.id.male:
                        input4 = "Male";
                        break;
                    case R.id.female:
                        input4 = "Female";

                        break;
                }

                if (checkbox.isChecked()) {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("input", input);
                    i.putExtra("input1", input1);
                    i.putExtra("input2", input2);
                    i.putExtra("input3", input3);
                    i.putExtra("input4", input4);
                    i.putExtra("txttime", txttime);
                    i.putExtra("datetime", date);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Please agree to terms!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == btnDatePicker) {

                    // Get Current Date

                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);

                    datePickerDialog = new DatePickerDialog(MainActivity.this, onDateSetListener, mYear, mMonth, mDay);

                    datePickerDialog.show();
                }

            }
        });

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == btnTimePicker) {

                    // Get Current Time
                    final Calendar c = Calendar.getInstance();
                    mHour = c.get(Calendar.HOUR_OF_DAY);
                    mMinute = c.get(Calendar.MINUTE);

                    // Launch Time Picker Dialog
                    TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                            new TimePickerDialog.OnTimeSetListener() {

                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay,
                                                      int minute) {

                                    txtTime.setText(hourOfDay + ":" + minute);
                                }
                            }, mHour, mMinute, false);
                    timePickerDialog.show();
                }

            }
        });
    }


    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override

        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            //Toast.makeText(DataTimePicker.this, year+"/"+month+"/"+dayOfMonth, Toast.LENGTH_SHORT).show();
            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

        }

    };

    public void dfg(View view) {
        String input = name.getText().toString();
        String input1 = email.getText().toString();
        String input2 = phonenumber.getText().toString();
        String input3 = age.getText().toString();
        int id = radiogrp.getCheckedRadioButtonId();
        String txttime = txtTime.getText().toString();
        String date = txtDate.getText().toString();
        ///RadioButton radioButton = (RadioButton) findViewById(id);
        // = radioButton.getText().toString();
        switch (id) {
            case R.id.male:
                input4 = "Male";
                break;
            case R.id.female:
                input4 = "Female";

                break;
        }

        if (checkbox.isChecked()) {
            Toast.makeText(this, input + "\n" + input1 + "\n" + input2 + "\n" + input3 + "\n" + input4 + "\n" + txttime + "\n" + date, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Please agree to terms!", Toast.LENGTH_SHORT).show();
        }

    }

}















