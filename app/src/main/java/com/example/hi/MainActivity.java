package com.example.hi;

import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityLogic.ActivityProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5f,getResources().getDisplayMetrics());
        MainActivityLogic mainActivityLogic=new MainActivityLogic(this);
    }


    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            Looper.prepare();

            Looper.loop();
        }

    }




}
