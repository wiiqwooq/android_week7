package com.example.week1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Week7 extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button=findViewById(R.id.button4);
        tv1=findViewById(R.id.textView6);
        tv2=findViewById(R.id.textView3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_week7);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addContact(new Contact(tv1,tv2));
                List<Contact> contacts = db.getAllContacts();

//                Contact mContact=db.getContact(2);
               Toast.makeText(
                        getApplicationContext(),contacts.get(0)._name,
                       Toast.LENGTH_LONG
              ).show();


            }
        });


    }
}
