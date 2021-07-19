package com.example.hi.router

//shl kotlin 位运算符 << 1  or 是 |   and 是 &
class RouterFlag {
    companion object{
        const val FLAG_LOGIN=0x01
        const val FLAG_AUTHENTICATION=FLAG_LOGIN shl 1
        const val FLAG_VIP=10086
    }
}