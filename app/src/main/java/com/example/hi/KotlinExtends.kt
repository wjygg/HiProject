package com.example.hi

import android.app.Activity
import android.view.View

//kotlin 扩展函数

fun main(){
    var mutableList= mutableListOf(1,2,3)
    mutableList.swap(0,1)
}

//泛型扩展方法
fun <T> MutableList<T>.swap(index1:Int,index2:Int){
    var tmp=this[index1]
    this[index1]= this[index2]
    this[index2]=tmp
}
//let 扩展非空 apply 类似 java build模式  run 类里面的 属性

fun <T: View> Activity.find(id:Int):T{
    return  this.findViewById<T>(id)
}

fun Int.onClick(activity: Activity,onClick:(view:View)-> Unit){
    activity.find<View>(this).apply {
        setOnClickListener {
            onClick(it)
        }
    }
}