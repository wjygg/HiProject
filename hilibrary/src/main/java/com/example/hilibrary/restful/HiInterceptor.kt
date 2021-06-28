package com.example.hilibrary.restful

interface HiInterceptor {

    fun intercept(chain:Chain):Boolean

    interface Chain{

        val isRequestPeriod :Boolean get() = false

        fun request():HiRequest


        fun response():HiResponse<*>

    }
}