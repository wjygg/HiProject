package com.example.hilibrary.executor

import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


object HiExecutor {

    var hiExecutor:ThreadPoolExecutor? =null

    init {
        var cpuCount=Runtime.getRuntime().availableProcessors()
        var corePoolSize=cpuCount+1
        var maximumPoolSize=cpuCount*2+1
        var keepAliveTime=30L
        var timeUnit= TimeUnit.SECONDS
        var blockingDeque:PriorityBlockingQueue< Runnable> = PriorityBlockingQueue()
        hiExecutor=object : ThreadPoolExecutor(1, 2, 30L, TimeUnit.SECONDS, PriorityBlockingQueue()) {
            override fun beforeExecute(t: Thread, r: Runnable) {

            }
        }
    }

}