package org.devio.hi.tab.common

interface IHiTab<D>:IHiTabLayout.OnTabSelectedListener<D> {

    fun setHiTabInfo(data:D)

    fun resetHeight(height:Int)
}