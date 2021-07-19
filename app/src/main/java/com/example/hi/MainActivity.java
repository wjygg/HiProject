package com.example.hi;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainActivityLogic.ActivityProvider {

    private ArrayList<String> list=new ArrayList<String>();
    private ArrayList[] list1=new ArrayList[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5f,getResources().getDisplayMetrics());
        MainActivityLogic mainActivityLogic=new MainActivityLogic(this);

    }











}
