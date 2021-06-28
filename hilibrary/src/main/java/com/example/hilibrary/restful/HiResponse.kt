package com.example.hilibrary.restful

import com.example.hilibrary.restful.annotation.Headers

open class HiResponse<T> {
    companion object{
        val SUCCESS:Int=0
    }

    var rowData:String?=null //原始数据

    var code=0//业务状态码

    var data:T ?=null //实体类

    var errorData:MutableMap<String,String> ?=null

    var msg:String? =null //错误信息






}