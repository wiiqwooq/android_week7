package com.example.week1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Week5 extends AppCompatActivity {
    Button button,button2,button3;
    ImageView mImageView,mImageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week5);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button22);
        button3=findViewById(R.id.button33);
        mImageView=findViewById(R.id.mImageView);
        mImageView2=findViewById(R.id.imageView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Intent myIntent = new Intent(Intent.ACTION_PICK,
                            android.provider.ContactsContract.Contacts.CONTENT_URI);
                    startActivityForResult(myIntent,222);
                }
                catch(Exception e) {
                    Log.d("Week4(onClick)", e.getMessage());
                }
            }
        });
         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent myIntent = new Intent();
                 myIntent.setType("*/*");
                 myIntent.setAction(Intent.ACTION_GET_CONTENT);
                 startActivityForResult(myIntent, 0);
             }
         });
         button3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                     startActivityForResult(takePictureIntent, 1);
                 }
             }
         });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            if(mImageView.getDrawable() == null) {
                mImageView.setImageBitmap(imageBitmap);
            } else {
                mImageView2.setImageBitmap(imageBitmap);
            }
        }


        try {
            switch (requestCode) {

                case 222: {
                    if (resultCode == Activity.RESULT_OK) {
                        String returnedData = data.getDataString();
                        Toast.makeText(getApplication(), "id " + returnedData,
                                Toast.LENGTH_LONG).show();
//Call selected view.
                        Intent myIntent2 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(returnedData));
                        startActivity(myIntent2);

                    } else {
                    }
                    break;
                }
                case 0:
                    if (resultCode == Activity.RESULT_OK) {
                        String selectedItem = data.getDataString();
                        Toast.makeText(getApplication(), "id " + selectedItem, Toast.LENGTH_LONG).show();
//Call selected view.
                        Intent myIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedItem));
                        startActivity(myIntent3);
                    } else {
                        Log.d("Week4 onActivityResult ", "Selection Cancelled " + requestCode + " " + resultCode);
                    }
                    break;

            }
        } catch (Exception e) {
            Log.d("Week4(onActivityResult)", e.getMessage());
        }


    }

}