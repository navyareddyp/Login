package com.example.android.login;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitActivity extends AppCompatActivity {

    EditText editText1,editText2;
    String number,smsmsg;
    Button button;
    int PICK_CONTACT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        editText1= (EditText) findViewById(R.id.editText);

        editText2= (EditText) findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_DEFAULT,  ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
                OpnContact();
            }
        });
        }

    public void OpnContact() {
        number=editText1.getText().toString();

        smsmsg=editText2.getText().toString();

        SmsManager smsManager =  SmsManager.getDefault();
        smsManager.sendTextMessage(number,null,smsmsg,null,null); //we need to add permission in manifest file to send sms
        Toast.makeText(this, "Sms Send successfully!", Toast.LENGTH_SHORT).show();
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if(resultCode == PICK_CONTACT) {
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c = managedQuery(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
                        // TODO Fetch other Contact details as you want to us
                    }
                }
        }
    }
}

