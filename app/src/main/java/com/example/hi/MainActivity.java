package com.example.hi;

import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements MainActivityLogic.ActivityProvider {

    private ArrayList<String> list=new ArrayList<String>();
    private ArrayList[] list1=new ArrayList[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5f,getResources().getDisplayMetrics());
        MainActivityLogic mainActivityLogic=new MainActivityLogic(this);

        KotlinDemo kotlinDemo=new KotlinDemo();


    }


    //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
    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            Looper.prepare();

            Looper.loop();
        }

    }








}
