package com.example.hi

import android.view.View


//主构造方法https://www.jianshu.com/p/883633496701
open class KotlinClass constructor( var name:String){

   // 主构造器中，使用 var 声明的参数，将成为成员变量(protect  String name)，可以在类的各个方法中调用。
   // 而不使用 var 声明参数，只是临时变量，只能在 init 方法体中使用。
    init {
    }
    //次构造方法调用主构造方法
    constructor( view: View, name:String) : this(name){
    }

    open fun eat(){
      name
    }



}


//默认final 类型 open 修饰
class Kotlinclass2 :KotlinClass {

    constructor(tets:String):this(tets,"15"){

    }

   constructor(tets:String,age:String):super(tets){

   }


    override fun eat() {
      var name1:String=name
    }
}

class A :KotlinClass{

    public constructor(name:String,age:Int):super(name){
    }
    public constructor(name:String,age:Int,sex:String):this(name,age){
    }


}

data class B(var int:Int){

}



abstract class Test{
    abstract fun add()
}

class testAbstract{

    fun addTest(test:Test){
    }
}

fun main(){



    //对象表达式 简便不需要创建类 局部变量
    var obj= object {
        var a:Int=0
        var b:Int=0
    }
    testAbstract().addTest(object: Test() { //继承类
        override fun add(){

        }
    })

}


