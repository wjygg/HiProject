package com.example.hilibrary.restful

open class HiRestful constructor(var baseUrl:String,callFactory:HiCall.Factory){

    private var interceptors:MutableList<HiInterceptor> = ArrayList()

    
}