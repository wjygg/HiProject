package com.example.hi;

import com.example.hi.xian.MyThread;

public class Xian {

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.setPriority(6);
        myThread.run();

    }

}


