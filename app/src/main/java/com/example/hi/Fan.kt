package com.example.hi

import kotlin.random.Random

//泛型类
class Fan<T>(var sex1:Int): FanInterface<T>(sex1){

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
}

open class FanInterface<T>(var sex:Int){

}


fun main() {
    var fan=Fan<String>(1)
    var arrays= arrayOfNulls<String>(3)
    arrays[0]="测试1"
    arrays[1]="测试2"
    arrays[2]="测试3"

    for((index,array) in arrays.withIndex()){
        fan.set(array!!)
    }

    println(fan.get())

}