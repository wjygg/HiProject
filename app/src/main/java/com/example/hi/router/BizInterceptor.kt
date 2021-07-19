package com.example.hi.router

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import java.lang.RuntimeException


@Interceptor(priority = 8,name = "BizInterceptor" )
class BizInterceptor : IInterceptor{
    private var context:Context ?=null

    override fun init(context: Context?) {
        this.context=context
    }

    override fun process(postcard: Postcard?, interceptorCallback: InterceptorCallback?) {
        var flag=postcard!!.extra
        if(flag===RouterFlag.FLAG_VIP){
            //未登录拦截
            interceptorCallback!!.onInterrupt(RuntimeException("需要登陆"))
            showToast("请先登录")
        }else{
            interceptorCallback!!.onContinue(postcard)
        }
    }

    private fun showToast(message:String) {

        Handler(Looper.getMainLooper()).post(object :Runnable{
            override fun run() {
                Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
            }
        })


    }
}