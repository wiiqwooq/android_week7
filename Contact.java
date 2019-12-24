package com.example.week1;

import android.widget.TextView;

public class Contact {
    public int _id;
    public String _name;
    public String _phone_number;
    public Contact(TextView tv1, TextView tv2){}
    public Contact(String name, String _phone_number)
    {
        this._name = name;
        this._phone_number = _phone_number;
    }
    public Contact(int id, String name, String _phone_number)
    {
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    public Contact() {

    }
}
