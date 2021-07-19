package com.example.hi

import java.io.IOException

class KotlinDemo1{

    var name="测试"

    fun one(){
        when(name){

            "1" -> 1

            "2" -> 2

            else ->{
                3
            }
        }
    }

    fun fiX(age:String,action:(age:String)->Unit){
       action(age)
    }

    fun three(){

        fiX("1") { age: String -> println(age) }

        fiX("1",::four) //函数引用
    }


    private fun four(age: String){
        println(age)
    }

    var two:(str:String,age:Int)->String={str: String, age: Int ->  str} // 变量类型为函数


    //field 代表这个变量  重写get set 方法
    var test:String="测试题"
        get() = field.replace("测试","")
        set(value) {
            field=value.replace("测试","")
        }


    fun five(){
        var arrays= arrayListOf<String>("4","5","6")
        for(item in arrays.indices){
            println(item)
        }

    }



}

fun main() {
    KotlinDemo1().five()
}