package com.example.hi

interface Drinks<T>{
    fun taste():T
    fun taste1(t:T)
}

//泛型类
abstract class FanClass<T>(t:T){
   var t:T
    init {
        this.t=t
    }
}

//泛型方法
fun <T> fromJson(json:String,zClass:Class<T>):T{
    var t:T=zClass.newInstance()
    return t
}

//泛型约束 T有多个上界类似 java extends
fun <T> sort(t:List<T>) where T:CharSequence,T:Comparable<T>{

}

//泛型逆变 in 下届通配符
fun inout(list:List<out Int>){

}
//泛型斜变 out 上界通配符

fun main(){
    sort(listOf("1","2","3"))
}

//korlin 注解
@Target(AnnotationTarget.FIELD) //目标
@Retention(AnnotationRetention.RUNTIME) //运行
annotation class Anmotation(val value:String)
