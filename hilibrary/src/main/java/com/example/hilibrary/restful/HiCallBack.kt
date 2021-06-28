package com.example.hilibrary.restful

interface HiCallBack<T>{

    fun onSuccess(response:HiResponse<T>)
    fun onFailed(throwable: Throwable)

}
