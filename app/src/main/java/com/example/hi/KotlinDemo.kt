package com.example.hi

class KotlinDemo {

    fun main(){
        println("-----main----")
        baseType()
        arrayTypes()
        jihe()
        jihe()
    }

    fun arrayTypes() {
        val array= arrayOf(1,2,3)
        val array1= arrayOfNulls<String>(3)
        val array2 = Array(3){i->(i*i).toString()}
        val array3= IntArray(5)
        println(array3)

        //遍历数组
        for((index,item) in array3.withIndex()){
        }
        array3.forEachIndexed{ index, array ->
            println("index:${index}array:${array}")

        }
    }


    fun baseType(){

        val num1=1.68;
        val nun2=2
        println("$num1")
    }


    fun jihe(){
        // 不可变集合
        val stringList= listOf<String>("one","two","three")

        val setList:Set<String> = setOf("one","one")

        val mapList= mapOf<Int,Int>(1 to 2)

        println("$stringList")
        println("$setList")

        //可变集合
        val numbers:MutableList<Int> = mutableListOf(1,2,3,4)
        numbers.add(5)
        numbers.removeAt(1)
        println(numbers)

        val numberSets = mutableSetOf<Int>(1,2,1,4)
        numbers.add(5)
        numbers.removeAt(1)
        println(numberSets)

        val mapValues=mutableMapOf<String,String>("key1" to "1")
        mapValues.put("key2" , "2")
        mapValues.containsValue("key1")
        mapValues.forEach{ it:Map.Entry<String,String>->it.key }
        mapValues.forEach  { key:String,value:String-> key+value }
    }


}