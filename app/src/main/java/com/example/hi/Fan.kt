package com.example.hi

import android.support.v4.app.Fragment
import kotlin.random.Random

//泛型类
class Fan<T>: FanInterface<T>{

    var list:MutableList<T> = ArrayList<T>()
    var random= java.util.Random()

     fun get():T{
        return list.get(random.nextInt(list.size))
    }

     fun set(value: T) {
        if(value!=null){
            list.add(value)
        }
    }

    fun <E> mether(t:E):E{
        return  t
    }

    fun show(fan: Fan<out String>){
        // fan.add(Fan<String>()) //类型通配符上限list 不能填充元素
    }
}

interface FanInterface<T>{

}

interface Info<T>{

    fun info(t:T):T

}
class InfoImpl:Info<Int> {

    override fun info(t: Int):Int {

        return  t
    }

}




fun main() {
    var fan2:Fan<*> = Fan<String>()   //* 泛型实参 标记类型时使用 Out 上界通配符 extends
    var fan:Fan<out String> = Fan<String>()
    var fan1=Fan<String>()
    var arrays= arrayOfNulls<String>(3)
    arrays[0]="测试1"
    arrays[1]="测试2"
    arrays[2]="测试3"

    for((index,array) in arrays.withIndex()){
        fan1.set(array!!)
    }
    //* ? 泛型通配符 实参时候用
    println(fan1.get())

    val info = InfoImpl::class.java
    val declaredMethods = info.declaredMethods
    for (declaredMethod in declaredMethods){ //泛型擦除无限制泛型擦除 any类型 有限制 extends 类型
        println(declaredMethod.returnType.simpleName+"----"+declaredMethod.name)  //泛型擦除桥接方法object
    }

    var list:MutableList<String> = ArrayList<String>()

}