package com.example.week1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class UI extends AppCompatActivity {

    EditText nameEdt;
    ImageButton imgBtn;
    CheckBox Cb1,Cb2;
    RadioButton Rbtn1,Rbtn2;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        nameEdt=findViewById(R.id.editText);
        imgBtn=findViewById(R.id.imageButton);

        Cb1=findViewById(R.id.checkBox);
        Cb2=findViewById(R.id.checkBox2);

        Rbtn1=findViewById(R.id.radioButton);
        Rbtn2=findViewById(R.id.radioButton2);

        spin=findViewById(R.id.spinner);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameStr=nameEdt.getText().toString();
                String radio=Rbtn1.getText().toString();
                String checkbox=Cb1.getText().toString();
                Object sp=spin.getItemAtPosition(1);
                Toast.makeText(
                        getApplicationContext(),
                        "My name is "+nameStr+" I'm "+radio
                        +"I like "+checkbox+"I like "+sp,
                        Toast.LENGTH_LONG).show();
            }
        });

        final String[] teamList = getResources().getStringArray(R.array.team);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,teamList);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Select : "+teamList[position],
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testRadioButtonCheck(view);
            }
        });

        Rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testRadioButtonCheck(view);
            }
        });

        Cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked=((CheckBox)view).isChecked();
                Toast.makeText(getApplicationContext(),
                        "I like Cola ",Toast.LENGTH_LONG).show();
            }
        });
        Cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked=((CheckBox)view).isChecked();
                Toast.makeText(getApplicationContext(),
                        " I like Water ",Toast.LENGTH_LONG).show();
            }
        });
    }
    void testRadioButtonCheck(View view){
// Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        String result = "";
// Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    result = "I'm Male";
                break;
            case R.id.radioButton2:
                if (checked)
                    result = "I'm Female";
                break;
        }
        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
    }
}

