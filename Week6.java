package com.example.week1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Week6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week6);

        Button button;
        button=findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=getApplicationContext();
                EditText editText;
                editText=findViewById(R.id.editText3);
                SharedPreferences share=context.getSharedPreferences("share",context.MODE_PRIVATE);

                if(!editText.getText().toString().equals("")) {
                    SharedPreferences.Editor editor = share.edit();
                    editor.putInt("highscore", Integer.parseInt(editText.getText().toString()));
                    editor.commit();
                    int highscore=share.getInt("highscore",-1);
                    Toast toast=Toast.makeText(context,"High score"+highscore,Toast.LENGTH_LONG);
                    toast.show();

                }
                else
                {
                    int highscore=share.getInt("highscore",-1);
                    Toast toast=Toast.makeText(context,""+highscore,Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });



    }
}
