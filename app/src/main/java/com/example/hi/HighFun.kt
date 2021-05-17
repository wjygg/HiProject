package com.example.hi

fun main(){

    //函数作为参数
     val mutableList=mutableListOf<Int>()
         mutableList.add(0)
         mutableList.add(1)
         mutableList.add(3)
         mutableList.sum { it-> println(it) }

       val sum1=mutableList.sum1()(5)
       testClosure(1)(2){ println(it)}
}


//扩展函数 函数作为参数
fun List<Int>.sum(action:(int:Int)->Unit):Int{
    var result=0
    this.forEach { it->
        result += it
        action(it)
    }
    return result
}
//函数作为返回值
fun List<Int>.sum1():(scal:Int)->Int{
    return fun(scal:Int):Int{
        var result=0
        this.forEach {
            result+=it*scal
        }
        return result
    }
}

//闭包

fun testClosure(v1:Int):(v2:Int,action:(Int)->Unit)->Unit{
    return fun(v2:Int,action:(Int)->Unit):Unit{
        action(v1+v2)
    }


}


