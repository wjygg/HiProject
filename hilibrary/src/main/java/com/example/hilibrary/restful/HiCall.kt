package com.example.hilibrary.restful

import java.io.IOException
import java.lang.Exception

interface HiCall<T> {

    @Throws(IOException::class)
    fun execute():HiResponse<T> //同步方法

    fun enqueue(callBack:HiCallBack<T>) //异步方法


    interface Factory{
        fun newCall(request:HiRequest):HiCall<*>
    }
}