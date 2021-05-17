package com.example.hi

import java.lang.StringBuilder

class FunctionLambda {

    fun test1(int1:Int,int2:Int):Int{
        return 1
    }

    val test1={arg:Char,str:String->arg+str}

    companion object { //伴生对象 里面的都是静态方法


        fun test2(int1:Int,int2:Int):Int{
            return 1
        }
    }
}

object FunctionLambda1{ //静态类
}

fun main(){
    append('1','2','3')
    test1('1',"2")


    var test3: ((Int) -> Boolean)? =null
         test3 = {num->num>10}

}
//可变数量参数
fun append(vararg arg:Char):String{

    val stringBuild=StringBuilder()
    arg.forEachIndexed { index, item ->
        stringBuild.append(item)
    }

    return stringBuild.toString()
}

//定义了一个方法类型的变量赋值了
val test2:(int:Int)-> Unit ={ it->
    it.toString()
}

val test1={arg:Char,str:String->arg+str}


