package com.example.hi.router

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.service.DegradeService
import com.alibaba.android.arouter.launcher.ARouter

/**
 * 目标页不存在跳转到 错误页面
 */
class DegradeServiceImpl :DegradeService{

    override fun init(context: Context?) {

    }

    override fun onLost(context: Context?, postcard: Postcard?) {
         //greenChannel不拦截
        ARouter.getInstance().build("/page/error/activity").greenChannel().navigation()
    }
}