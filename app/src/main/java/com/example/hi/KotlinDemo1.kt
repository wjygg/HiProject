package com.example.hi

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

    fun fix(age:Int,name:String="测试"){
    }

     var two:()->String={"测试"} // 变量类型为函数

}