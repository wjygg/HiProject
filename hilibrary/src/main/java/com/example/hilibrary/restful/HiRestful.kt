package com.example.hilibrary.restful

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.concurrent.ConcurrentHashMap

open class HiRestful constructor( var baseUrl:String,var callFactory:HiCall.Factory){

    //拦截器
    private var interceptors:MutableList<HiInterceptor> = mutableListOf()

    private var methodService:ConcurrentHashMap<Method,MethodParser> = ConcurrentHashMap()

    fun addInterceptors(interceptor:HiInterceptor){
        interceptors.add(interceptor)
    }

    //一定是getGenericParameterTypes（）方法，getParameterTypes得到的参数列表Type对象时不保存泛型类型的。
    //service.classLoader 被代理类的 classLoader
    fun <T> create(service:Class<T>):T{
        return  Proxy.newProxyInstance(service.classLoader, service.interfaces
        ,object : InvocationHandler{
                override fun invoke(proxy: Any?, method: Method, args: Array<out Any>?): Any {

                    var methodParser = methodService.get(method)
                    if (methodParser == null) {
                        methodParser = MethodParser.parse(baseUrl, method)
                        methodService[method] = methodParser
                    }
                   var request =methodParser.newRequest(method,args)
                    return request
                }
            })  as T
    }

}