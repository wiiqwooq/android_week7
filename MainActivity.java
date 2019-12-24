package com.example.week1;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //1. ประกาศตัวแปรที่เกี่ยวกับ View
    TextView tv;
    Button btn;
    EditText edt;
    EditText edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. เรียกใช้ view จาก XML
        tv = findViewById(R.id.textView);
        btn= findViewById(R.id.button);
        edt= findViewById(R.id.editText);
        edt2= findViewById(R.id.editText2);

        //3. ใช้งาน
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int num1=Integer.parseInt(edt.getText().toString());
                int num2=Integer.parseInt(edt2.getText().toString());

            tv.setText((num1+num2)+"");
            }
        });
    }
}
